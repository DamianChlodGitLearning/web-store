package com.mycompanyname.webstore.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*working example of in memory configuration
/*@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Admin").password("Admin123").roles("ADMIN");
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/products/add").hasRole("ADMIN").and().formLogin().loginPage("/login")
				.loginProcessingUrl("/j_spring_security_check").defaultSuccessUrl("/products/add", true)
				.failureUrl("/loginfailed").permitAll().and().csrf().disable().logout()
				.logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/products");
	}

}*/
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("SELECT name as username, password, enabled from USER_TABLE where name=?")
				.authoritiesByUsernameQuery(
						"SELECT ut.NAME as username, rt.NAME as role FROM ROLE_TABLE rt JOIN USER_ROLE_MATCH_TABLE urmt ON rt.ROLE_ID = urmt.ROLE_ID JOIN USER_TABLE ut ON urmt.USER_ID = ut.USER_ID WHERE ut.NAME = ?");
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/products/add").access("hasRole('ROLE_ADMIN')").antMatchers("/users")
				.access("hasRole('ROLE_VENDOR')").and().formLogin().loginPage("/login")
				.loginProcessingUrl("/j_spring_security_check").failureUrl("/loginfailed").permitAll()
				.usernameParameter("j_username").passwordParameter("j_password").and().csrf().disable().logout()
				.logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/products").and().exceptionHandling()
				.accessDeniedPage("/403");

	}
}

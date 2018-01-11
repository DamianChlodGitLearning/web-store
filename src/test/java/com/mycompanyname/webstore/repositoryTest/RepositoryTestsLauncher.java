package com.mycompanyname.webstore.repositoryTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages="com.mycompanyname.webstore.domain")
@EnableJpaRepositories("com.mycompanyname.webstore.repository")
public class RepositoryTestsLauncher {
	public static void main(String[] args) {
		SpringApplication.run(RepositoryTestsLauncher.class, args);
	}
}

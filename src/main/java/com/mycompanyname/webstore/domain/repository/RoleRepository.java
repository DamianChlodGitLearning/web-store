package com.mycompanyname.webstore.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mycompanyname.webstore.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

	@Query("select r from Role r join r.userList u where u.userId= :userId")
	List<Role> findRolesByUserId(@Param("userId") int userId);
	
}

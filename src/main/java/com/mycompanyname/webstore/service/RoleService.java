package com.mycompanyname.webstore.service;

import java.util.List;

import com.mycompanyname.webstore.domain.Role;

public interface RoleService {

	List<Role> findRolesByUserId(int userId);

}

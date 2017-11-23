package com.mycompanyname.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompanyname.webstore.domain.Role;
import com.mycompanyname.webstore.domain.repository.RoleRepository;
import com.mycompanyname.webstore.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public List<Role> findRolesByUserId(int userId) {
		return roleRepository.findRolesByUserId(userId);
	}

}

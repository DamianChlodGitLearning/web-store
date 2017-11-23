package com.mycompanyname.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompanyname.webstore.domain.User;
import com.mycompanyname.webstore.domain.repository.UserRepository;
import com.mycompanyname.webstore.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findByUserId(int userId) {
		return userRepository.findByUserId(userId);
	}

}

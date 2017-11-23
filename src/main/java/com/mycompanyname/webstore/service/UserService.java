package com.mycompanyname.webstore.service;

import java.util.List;
import com.mycompanyname.webstore.domain.User;

public interface UserService {

	List<User> findAll();

	User findByUserId(int userId);

}

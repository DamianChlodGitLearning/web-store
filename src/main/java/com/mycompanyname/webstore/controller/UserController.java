package com.mycompanyname.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mycompanyname.webstore.domain.User;
import com.mycompanyname.webstore.service.RoleService;
import com.mycompanyname.webstore.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	@RequestMapping
	public String Add(Model model) {
		User newUser = new User();
		model.addAttribute("users", userService.findAll());
		model.addAttribute("newUser", newUser);
		return "users";
	}

	@RequestMapping("/details/{Id}")
	public String Details(Model model, @PathVariable("Id") int userId) {
		model.addAttribute("user", userService.findByUserId(userId));
		model.addAttribute("userRole", roleService.findRolesByUserId(userId));
		return "userDetails";
	}
}

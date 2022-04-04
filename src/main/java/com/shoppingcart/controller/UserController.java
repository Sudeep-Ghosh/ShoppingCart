package com.shoppingcart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.entity.User;
import com.shoppingcart.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/registerUser")
	public User registerUser(@RequestBody User user) {
		return service.registerUser(user);
	}

	@GetMapping("/users")
	public List<User> showUser() {
		return service.showUser();
	}

	@GetMapping("/{userId}")
	public Optional<User> getUserById(@PathVariable("userId") Long id) {
		return service.getUser(id);
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public void deleteUser(@PathVariable Long userId) {
		service.deleteUser(userId);
	}
}

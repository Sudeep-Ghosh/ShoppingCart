package com.shoppingcart.service;

import java.util.List;
import java.util.Optional;

import com.shoppingcart.entity.User;

public interface UserService {

	public User registerUser(User user);
	
	public List<User> showUser();
	
	public Optional<User> getUser(Long id);
	
	public void deleteUser(Long userId);
}

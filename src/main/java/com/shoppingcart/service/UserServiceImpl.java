package com.shoppingcart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.entity.User;
import com.shoppingcart.exception.UserNotExistsException;
import com.shoppingcart.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	// registerUser(User): for adding User in User Table
	@Override
	public User registerUser(User user) {
		return repository.save(user);
	}

	// getUser(long): for fetching particular User from User Table By User Id
	@Override
	public Optional<User> getUser(Long id){
		Optional<User> user=repository.findById(id);
		return repository.findById(id);
	
	}

	// showUser(): for displaying list of Users
	@Override
	public List<User> showUser() {
		return repository.findAll();
	}

	// deleteUser(Long): for delete User from User Table
	@Override
	public void deleteUser(Long userId) {
		repository.deleteById(userId);
	}
}

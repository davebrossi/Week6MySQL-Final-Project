package com.promineo.tech.Service;

import java.util.ArrayList;

import com.promineo.tech.Models.User;
import com.promineo.tech.Repository.UserRepository;

public class UserService implements IUserService {
private UserRepository userRepository;
	
	public UserService()
	{
		userRepository = new UserRepository();
	}
	
	@Override
	public ArrayList<User> getUser()
	{
		return userRepository.getUser();
	}

	@Override
	public User getUser(int userId) {
		return userRepository.getUser(userId);
	}

	@Override
	public void createUser(User user) {
		userRepository.createUser(user);
	}

	@Override
	public void deleteUser(User user) {
		userRepository.deleteUser(user);
	}
	@Override
	public void updateUser(User user) {
		userRepository.updateUser(user);
	}
	
}

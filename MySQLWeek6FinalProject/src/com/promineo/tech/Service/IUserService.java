package com.promineo.tech.Service;

import java.util.ArrayList;

import com.promineo.tech.Models.User;

public interface IUserService {
	ArrayList<User> getUser();
	User getUser(int userId);
	void createUser(User user);
	void deleteUser(User user);

}

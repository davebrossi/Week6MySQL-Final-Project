package com.promineo.tech.Repository;

import java.util.ArrayList;

import com.promineo.tech.Models.User;

public interface IUserRepository {
	ArrayList<User> getUser();
	User getUser(int userId);
	void createUser(User user);
	void deleteUser(User user);
	void updateUser(User user);
}

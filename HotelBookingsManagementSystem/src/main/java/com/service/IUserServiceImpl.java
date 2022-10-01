package com.service;

import java.util.List;

import com.entity.User;

public interface IUserServiceImpl {
	public User addUser(User user);
	public User updateUser(User user);
	public String removeUser(int userId);
	public List<User> showAllUsers();
	public User showUser(int userId);
}

package com.service;

import java.util.List;

import com.advices.EmptyListException;
import com.advices.ResourceNotFoundException;
import com.entity.User;

public interface IUserService {
	public User addUser(User user);
	public User updateUser(User user) throws ResourceNotFoundException;
	public String removeUser(int userId) throws ResourceNotFoundException;
	public List<User> showAllUsers() throws EmptyListException;
	public User showUser(int userId) throws ResourceNotFoundException;
}

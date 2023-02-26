package com.masai.Service;

import java.util.List;

import com.masai.Exception.UserException;
import com.masai.Entity.*;

public interface IUserService {
	public User addUser(User user) throws UserException;
	public User updateUser(User user,String key) throws UserException;
	public User deleteUser(Integer userId,String key) throws UserException;
	public User viewUser(Integer userId,String key) throws UserException;
	public List<User> viewAllUsers(String key) throws UserException;
}
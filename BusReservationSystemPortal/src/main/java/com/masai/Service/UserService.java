package com.masai.Service;

import java.util.List;

import com.masai.Entity.User;
import com.masai.Exception.UserException;

public interface UserService {
	public User registerUser(User user);
	public User getUserByemail(User user) throws UserException;
	public List<User> getAllUser();

}

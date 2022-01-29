package com.rohitbaranwal.service;

import java.util.List;

import com.rohitbaranwal.model.User;

public interface UserService {
	//save
	public User save(User user);
	
	//getAllUser
	public List<User> getAllUser();

	//GetUserById
	public User getUserById(Integer id) throws Exception;

	//update
	public User update(User user);
	
	//delete
	public String delete(Integer id);

}

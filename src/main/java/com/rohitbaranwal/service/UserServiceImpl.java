package com.rohitbaranwal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohitbaranwal.model.User;
import com.rohitbaranwal.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	//save
	public User save(User user)
	{	
		User result=null;
			try {
				result= userRepository.save(user);
			}
			catch(Exception e)
			{
				System.out.println("Porblem in saving user resource"+e);
			}
			return result;
	}
	
	//getAllUser
	public List<User> getAllUser()
	{	
			List<User> users=(List<User>) userRepository.findAll();
			return users;	
	}
	
	//GetUserById
	public User getUserById(Integer id) throws Exception
	{	
		User user =userRepository.findById(id).orElseThrow(()-> new Exception("resource not found"+id));
		return user;
	}
	//update
	public User update(User user)
	{	
		User temp=userRepository.findById(user.getId()).orElseThrow();
		temp.setName(user.getName());
		temp.setAddress(user.getAddress());
		User result=userRepository.save(temp);
		return result;
	}
	//delete
	public String delete(Integer id)
	{	
			userRepository.deleteById(id);
		 return "deleted successfully";
	}

}

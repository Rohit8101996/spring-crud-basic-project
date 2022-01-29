package com.rohitbaranwal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohitbaranwal.model.User;
import com.rohitbaranwal.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
		
	@PostMapping
	public User save(@RequestBody User user)
	{
		
		User result=userService.save(user);
		return result;
	}
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") Integer id) 
	{
		User user = null;
		try {
		user=userService.getUserById(id);
		 return new ResponseEntity<>(user , HttpStatus.OK);
		
		}
		catch(Exception e)
		{
			System.out.println("no resource found");
		}
		return  new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping
	public List<User> getAllUsers()
	{
		
		List<User> allUsers=userService.getAllUser();
		return allUsers;
	}
	
	@PutMapping
	public String updateUser(@RequestBody User user)
	{
		if(user.getId()!=null)
		{
			userService.update(user);
			return "updated succesfully";
		}
		else
			{
			userService.save(user);
			return "no entity found creating new user and updating it";
			}
				
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id") Integer id)
	{
		String deleted=userService.delete(id);
		return deleted;
	}
	
}

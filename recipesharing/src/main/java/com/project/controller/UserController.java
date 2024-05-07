package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.User;
import com.project.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	// create user
@PostMapping("/users")
public User createUser (@RequestBody User user)throws Exception {
	
	User isExist=userRepository.findByEmail(user.getEmail());
	if(isExist!=null) {
		throw new Exception("user is exist with"+user.getEmail());
	}
	User savedUser =userRepository.save(user);
	return savedUser;
}

//delete user

@DeleteMapping("/users/{userId}")
public String deleteUser(@PathVariable Long userId) throws Exception {

userRepository.deleteById(userId);
return "User deleted succesfully";
}

//get all user

@GetMapping("/users")
public List<User> getallUsers() throws Exception {

 List<User> users = userRepository.findAll();
return users;
}

}



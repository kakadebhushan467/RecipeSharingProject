package com.project.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.project.Service.UserService;
import com.project.model.User;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/api/users/profile")
	public User findUserByJwt{@RequestHeader("Authorization") String jwt)throws Exception{
    

		User user=userService.findUserByJwt(jwt);
		return user;
	}
}



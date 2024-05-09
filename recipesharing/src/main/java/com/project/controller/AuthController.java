package com.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.config.JwtProvider;
import com.project.model.User;
import com.project.repository.UserRepository;
import com.project.responce.AuthRespose;

@RestController
@RequestMapping("/auth")


public class AuthController<CustomerUserDetailsService> {
	@Autowired
private UserRepository userRepository;
	@Autowired
private CustomerUserDetailsService customerUserDetails;
	@Autowired
private JwtProvider jwtProvider;
	@Autowired
private PasswordEncoder passwordEncoder;
	
	public AuthRespose createUser(@RequestBody User user)throws Exception{
		String email=user.getEmail();
		String password=user.getPassword();
		String  fullName=user.getFullName();
		
		User isExistEmail=userRepository.findByEmail(email);
		if(isExistEmail!=null) {
		throw new Exception ("Email is already used with another account");	
		}
		User createdUser=new User();
		createdUser.setEmail(email);
		createdUser.setPassword(passwordEncoder.encode(password));
		createdUser.setFullName(fullName);
		
		User saveUser=userRepository.save(createdUser);
		Authentication authentication=new UsernamePasswordAuthenticationToken(email,password);
		
		return null;
	}
}

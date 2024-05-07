package com.project.Service;

import com.project.model.User;

public interface UserService {
	
	public User findUserById(Long userId)throws Exception;

	public User findUserById(Long userId);

}

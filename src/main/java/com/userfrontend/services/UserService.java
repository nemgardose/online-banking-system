package com.userfrontend.services;

import java.util.Set;

import com.userfrontend.model.User;
import com.userfrontend.model.security.UserRole;

public interface UserService {
	
	User findByUsername(String username);
	User findByEmail(String email);
	boolean checkUserExists(String username, String email);
	boolean checkUsernameExists(String username);
	boolean checkEmailExists(String email);
	
	void save(User user);
	User createUser(User user, Set<UserRole> userRoles);
	User saveUser (User user); 

}

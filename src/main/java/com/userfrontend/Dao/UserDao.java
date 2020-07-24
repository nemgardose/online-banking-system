package com.userfrontend.Dao;

import org.springframework.data.repository.CrudRepository;

import com.userfrontend.model.User;

public interface UserDao extends CrudRepository<User, Long> {
	User findByUsername(String username);
	User findByEmail(String email);

}

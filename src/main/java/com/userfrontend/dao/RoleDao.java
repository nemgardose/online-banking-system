package com.userfrontend.dao;

import org.springframework.data.repository.CrudRepository;

import com.userfrontend.model.security.Role;

public interface RoleDao extends CrudRepository<Role, Integer> {
	Role findByName(String name);
}

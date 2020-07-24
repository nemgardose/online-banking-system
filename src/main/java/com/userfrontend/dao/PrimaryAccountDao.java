package com.userfrontend.dao;

import org.springframework.data.repository.CrudRepository;

import com.userfrontend.model.PrimaryAccount;

public interface PrimaryAccountDao extends CrudRepository<PrimaryAccount, Long> {
	PrimaryAccount findByAccountNumber(int accountNumber);
}

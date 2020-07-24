package com.userfrontend.dao;

import org.springframework.data.repository.CrudRepository;

import com.userfrontend.model.SavingsAccount;

public interface SavingsAccountDao extends CrudRepository<SavingsAccount, Long> {
	SavingsAccount findByAccountNumber (int accountNumber);

}

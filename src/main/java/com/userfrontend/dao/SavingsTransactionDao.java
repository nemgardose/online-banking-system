package com.userfrontend.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.userfrontend.model.SavingsTransaction;

public interface SavingsTransactionDao extends CrudRepository<SavingsTransaction, Long> {
	List<SavingsTransaction> findAll();
}

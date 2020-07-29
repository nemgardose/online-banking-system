package com.userfrontend.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.userfrontend.model.PrimaryTransaction;

public interface PrimaryTransactionDao extends CrudRepository<PrimaryTransaction, Long> {
	
	List<PrimaryTransaction> findAll();
	
}

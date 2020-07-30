package com.userfrontend.services;

import java.security.Principal;

import com.userfrontend.model.PrimaryAccount;
import com.userfrontend.model.PrimaryTransaction;
import com.userfrontend.model.SavingsAccount;
import com.userfrontend.model.SavingsTransaction;

public interface AccountService {
	PrimaryAccount createPrimaryAccount();
	SavingsAccount createSavingsAccount();
	void deposit(String accountType, double amount, Principal principal);
	void withdraw(String accountType, double amount, Principal principal);

}

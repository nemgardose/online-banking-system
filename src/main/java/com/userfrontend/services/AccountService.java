package com.userfrontend.services;

import java.security.Principal;

import com.userfrontend.model.PrimaryAccount;
import com.userfrontend.model.SavingsAccount;

public interface AccountService {
	PrimaryAccount createPrimaryAccount();
	SavingsAccount createSavingsAccount();
	void deposit(String accountType, double amount, Principal principal);
	void withdraw(String accountType, double amount, Principal principal);
}

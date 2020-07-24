package com.userfrontend.services;

import com.userfrontend.model.PrimaryAccount;
import com.userfrontend.model.SavingsAccount;

public interface AccountService {
	PrimaryAccount createPrimaryAccount();
	SavingsAccount createSavingsAccount();
}

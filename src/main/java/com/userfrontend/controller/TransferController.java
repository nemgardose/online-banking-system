package com.userfrontend.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.userfrontend.model.PrimaryAccount;
import com.userfrontend.model.SavingsAccount;
import com.userfrontend.model.User;
import com.userfrontend.services.TransactionService;
import com.userfrontend.services.UserService;

@Controller
@RequestMapping("/transfer")
public class TransferController {
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/betweenAccounts", method = RequestMethod.GET)
	public String betweenAccounts(Model model) {
		model.addAttribute("transferFrom", "");
		model.addAttribute("transferTo", "");
		model.addAttribute("amount", "");
		
		return "betweenAccounts";
	}
	
	@RequestMapping(value = "/betweenAccounts", method = RequestMethod.POST)
	public String betweenAccountsPost(
			@ModelAttribute("transferFrom") String transferFrom,
			@ModelAttribute("transferTo") String transferTo,
			@ModelAttribute("amount") String amount,
			Principal principal
			
	) throws Exception {
		User user = userService.findByUsername(principal.getName());
		PrimaryAccount primaryAccount = user.getPrimaryAccount();
		SavingsAccount savingsAccount = user.getSavingsAccount();
		transactionService.betweenAccountsTransfer(transferFrom, transferTo, amount, primaryAccount, savingsAccount);
		
		return "redirect:/userFront";
	}
	
	
	

}

package com.userfrontend.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.userfrontend.model.PrimaryAccount;
import com.userfrontend.model.PrimaryTransaction;
import com.userfrontend.model.SavingsAccount;
import com.userfrontend.model.SavingsTransaction;
import com.userfrontend.model.User;
import com.userfrontend.services.AccountService;
import com.userfrontend.services.TransactionService;
import com.userfrontend.services.UserService;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping("/primaryAccount")
	public String primaryAccount(Model model, Principal principal) {
		List<PrimaryTransaction> primaryTransactionList = transactionService.findPrimaryTransactionList(principal.getName());
		User user = userService.findByUsername(principal.getName());
		PrimaryAccount primaryAccount = user.getPrimaryAccount();
		
		model.addAttribute("primaryAccount", primaryAccount);
		model.addAttribute("primaryTransactionList", primaryTransactionList);
		
		return "primaryAccount";
	}
	
	@RequestMapping("/savingsAccount")
	public String savingsAccount(Model model, Principal principal) {
		List<SavingsTransaction> savingsTransactionList = transactionService.findSavingsTransactionList(principal.getName());
		User user = userService.findByUsername(principal.getName());
		SavingsAccount savingsAccount = user.getSavingsAccount();
		
		model.addAttribute("savingsAccount", savingsAccount);
		model.addAttribute("savingsTransactionList", savingsTransactionList);
		
		return "savingsAccount";
	}
	
	/*
	 * Deposit GET and POST Request
	 */
	
	@RequestMapping(value = "/deposit", method = RequestMethod.GET)
	public String deposit(Model model) {
		model.addAttribute("accountType", "");
		model.addAttribute("amount", "");
		
		return "deposit";
	}
	
    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    public String depositPost(@ModelAttribute("amount") String amount, @ModelAttribute("accountType") String accountType, Principal principal) {
        accountService.deposit(accountType, Double.parseDouble(amount), principal);

        return "redirect:/userFront";
    }
    
    /*
     * Withdraw GET and POST Request
     */
    @RequestMapping(value= "/withdraw", method = RequestMethod.GET)
    public String withdraw(Model model) {
    	model.addAttribute("accountType", "");
    	model.addAttribute("amount", "");
    	
    	return "withdraw";
    }
	 
    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    public String withdrawPost(@ModelAttribute("amount") String amount, @ModelAttribute("accountType") String accountType, Principal principal) {
    	accountService.withdraw(accountType, Double.parseDouble(amount), principal);
    	return "redirect:/userFront";
    }
    
	
	


}

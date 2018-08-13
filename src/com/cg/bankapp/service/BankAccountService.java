package com.cg.bankapp.service;

import java.util.Collection;

import com.cg.bankapp.dao.BankAccountCollection;
import com.cg.bankapp.pojo.BankAccount;


public class BankAccountService {

	private BankAccountCollection dao = new BankAccountCollection();
	
	public Collection <BankAccount> viewBankAccount(){
		return dao.viewBankAccount();
	}

	public double withdraw(double amount, int accountNumber) {
		return dao.withdraw(amount,accountNumber);
		
	}

	public double deposit(double depositAmount, int accountNumber) {
		// TODO Auto-generated method stub
		return dao.deposit(depositAmount,accountNumber);
	}

}

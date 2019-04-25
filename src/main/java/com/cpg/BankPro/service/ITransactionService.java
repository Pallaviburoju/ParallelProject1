package com.cpg.BankPro.service;

import com.cpg.BankPro.dto.Customerpojo;

public interface ITransactionService {
	
	int deposit(int accountNo,int amountTransferred,int balance);
	int withdraw(int accountNo,int amountTransferred,int balance);
	Customerpojo fundTransfer(Customerpojo pojo);
	int showBalance(int balance);

}

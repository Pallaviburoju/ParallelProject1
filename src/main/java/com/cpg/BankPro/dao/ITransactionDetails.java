package com.cpg.BankPro.dao;

import com.cpg.BankPro.dto.Customerpojo;

public interface ITransactionDetails {
	
	int deposit(int accountNo,int amountTransferred,int balance);
	int withdraw(int accountNo,int amountTransferred,int balance);
	Customerpojo fundTransfer(Customerpojo pojo);
	int showBalance(int balance);
	
}

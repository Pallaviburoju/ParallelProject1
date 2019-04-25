package com.cpg.BankPro.service;

import com.cpg.BankPro.dao.ITransactionDetails;
import com.cpg.BankPro.dao.TransactionDetailsImpl;
import com.cpg.BankPro.dto.Customerpojo;

public class TransactionServiceImpl implements ITransactionService{
Customerpojo pojo=new Customerpojo();
	ITransactionDetails dao2=new TransactionDetailsImpl();

		public int deposit(int accountNo,int amountTransferred,int balance) {
		
			return dao2.deposit(accountNo,amountTransferred,balance);

		}

		public int withdraw(int accountNo,int amountTransferred,int balance) {
			
			return dao2.withdraw(accountNo, amountTransferred, balance);
		}

		public Customerpojo fundTransfer(Customerpojo pojo) {
			
			return dao2.fundTransfer(pojo);
		}
		
		public int showBalance(int balance) {
			return dao2.showBalance(balance);
		}


}
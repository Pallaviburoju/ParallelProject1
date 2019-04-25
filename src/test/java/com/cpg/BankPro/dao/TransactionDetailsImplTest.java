package com.cpg.BankPro.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cpg.BankPro.dto.Customerpojo;

class TransactionDetailsImplTest {
	
	Customerpojo pojo=new Customerpojo();
	TransactionDetailsImpl dao2=new TransactionDetailsImpl();
	@Test
	void testDeposit() {
		assertEquals(1100,dao2.deposit(1,100,1000));
	}

	@Test
	void testWithdraw() {
		assertEquals(900,dao2.withdraw(1,100,1000));
	}

	@Test
	void testFundTransfer() {
	    pojo.setAmountTransferred(1000000);
		pojo.setFromAccountNo(1);
		pojo.setToAccountNo(14);
		assertEquals(null, dao2.fundTransfer(pojo));
	}

	@Test
	void testShowBalance() {
		assertEquals(1000,dao2.showBalance(1000));
	}

}

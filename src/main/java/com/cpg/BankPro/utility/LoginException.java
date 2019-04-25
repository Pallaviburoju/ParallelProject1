package com.cpg.BankPro.utility;

public class LoginException extends Exception{
	public LoginException() {
		System.err.println("Invalid account number or password");
	}
}

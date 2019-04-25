package com.cpg.BankPro.utility;

public class IncorrectAadharException extends Exception{
	
	public IncorrectAadharException() {
		System.err.println("Invalid Aadhar number");
	}
}

package com.cpg.BankPro.utility;

public class DatanotUpdatedInTableException extends Exception{
	public DatanotUpdatedInTableException() {
		System.err.println("Data not updated in the table");
	}
}

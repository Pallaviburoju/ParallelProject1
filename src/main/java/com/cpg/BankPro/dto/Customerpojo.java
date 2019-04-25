package com.cpg.BankPro.dto;

public class Customerpojo {
	private int accountNo;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private String pancardNo;
	private String aadharNo;
	private String address;
	private String mobileNo;
	private int balance;
	
	private int transactionId;
	private int fromAccountNo;
	private int toAccountNo;
	private int amountTransferred;
	
	public Customerpojo(int accountNo, String firstName, String lastName, String emailId, String password, String pancardNo,
			String aadharNo, String address, String mobileNo,int balance) {
		this.accountNo = accountNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password=password;
		this.pancardNo = pancardNo;
		this.aadharNo = aadharNo;
		this.address = address;
		this.mobileNo = mobileNo;
		this.balance=balance;
	}
	public Customerpojo() {
		// TODO Auto-generated constructor stub
	}
	public int getTransactionId() {
		return transactionId;
	}
	public int setTransactionId(int transactionId) {
		return this.transactionId = transactionId;
	}
	public int getFromAccountNo() {
		return fromAccountNo;
	}
	public void setFromAccountNo(int fromAccountNo) {
		this.fromAccountNo = fromAccountNo;
	}
	public int getToAccountNo() {
		return toAccountNo;
	}
	public void setToAccountNo(int toAccountNo) {
		this.toAccountNo = toAccountNo;
	}
	public int getAmountTransferred() {
		return amountTransferred;
	}
	public void setAmountTransferred(int amountTransferred) {
		this.amountTransferred = amountTransferred;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public int setAccountNo(int accountNo) {
		return this.accountNo = accountNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public String setPassword(String password) {
		return this.password = password;
	}
	public String getPancardNo() {
		return pancardNo;
	}
	public void setPancardNo(String pancardNo) {
		this.pancardNo = pancardNo;
	}
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public int getBalance() {
		return balance;
	}
	public int setBalance(int i) {
		return this.balance = i;
	}
}

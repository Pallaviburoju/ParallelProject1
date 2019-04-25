package com.cpg.BankPro.ui;

import java.util.Scanner;

import com.cpg.BankPro.dto.Customerpojo;
import com.cpg.BankPro.service.CustomerServiceImpl;
import com.cpg.BankPro.service.ICustomerService;
import com.cpg.BankPro.service.ITransactionService;
import com.cpg.BankPro.service.TransactionServiceImpl;
import com.cpg.BankPro.utility.LoginException;

public class Presentation {
	
    static Customerpojo dto=new Customerpojo();
    static Customerpojo pojo=new Customerpojo();
	static ICustomerService service=new CustomerServiceImpl();
	static ITransactionService service2=new TransactionServiceImpl();
	//obtaining details from customer to register
	public void customerDetails() {
		
		 Scanner scan=new Scanner(System.in);
		 System.out.println("Enter first name:");
		 dto.setFirstName(scan.next());
		 System.out.println("Enter last name:");
		 dto.setLastName(scan.next());
		 System.out.println("Enter email_id:");
		 dto.setEmailId(scan.next());
		 System.out.println("Create password:");
		 dto.setPassword(scan.next());
		 System.out.println("Enter pancard no:");
		 dto.setPancardNo(scan.next());
		 System.out.println("Enter aadhar card no:");
		 dto.setAadharNo(scan.next());
		 System.out.println("Enter address:");
		 dto.setAddress(scan.next());
		 System.out.println("Enter mobile no:");
		 dto.setMobileNo(scan.next());
		// dto.setBalance(0);
	     
	     System.out.println("You are successfully registered and your account number is "+service.registration(dto).getAccountNo());
	    
	}
	public void loggingin() {
	
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter account no");
		int acc=pojo.setAccountNo(scan.nextInt());
		System.out.println("Enter password");
		String pass=pojo.setPassword(scan.next());
		pojo=service.login(acc,pass);

		if(pojo!=null)
	    System.out.println("You are successfully logged in with account number and balance "+acc+ " and "+pass);
	
		else {
			System.out.println("fail");
				try {
					throw new LoginException();
				} catch (LoginException e) {
					e.printStackTrace();
				}
		}
 System.out.println("inlogginin"+pojo.getAccountNo()+pojo.getPassword());
		}
	
	public void loggedin(int accountNo,String amountTransferred,int balance) {
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Select option\n1. Deposit\n2. Withdraw\n3. Fund Transfer\n4. Show Balance");
		String ch;
		ch=scan.next();
		switch(ch){
		case "1": System.out.println("Enter the amount to be deposited");
		          pojo.setAmountTransferred(scan.nextInt());
		          service2.deposit(pojo.getAccountNo(),pojo.getAmountTransferred(),pojo.getBalance());
		          break;
		          
		case "2": System.out.println("Enter the amount to be withdrawn");
			      pojo.setAmountTransferred(scan.nextInt());
			      service2.withdraw(pojo.getAccountNo(),pojo.getAmountTransferred(),balance);
			      break;
			        
		case "3": System.out.println("Enter from account number");
		          pojo.setFromAccountNo(scan.nextInt());
		          System.out.println("Enter to account number");
		          pojo.setToAccountNo(scan.nextInt());
			      System.out.println("Enter amount to be transferred");
			      pojo.setAmountTransferred(scan.nextInt());
			      service2.fundTransfer(pojo);
			      System.out.println("Transaction of "+pojo.getAmountTransferred()+" done from"+pojo.getFromAccountNo()+" to "
			                          +pojo.getToAccountNo()+" with transaction id "+pojo.getTransactionId());
			      break;
			
		case "4": System.out.println("Your account balance is "+pojo.getBalance());
		          break;
			
		}
	}
	
	public static void main(String args[]) {
		Presentation object=new Presentation();
		do {
		Scanner scan=new Scanner(System.in);
		System.out.println("Select option\n1. Register\n2. Login\n3. Exit");
		String ch;
		ch=scan.next();
		
			switch(ch) {
				
			case "1":  object.customerDetails();
					   break;
						
			case "2":  object.loggingin();	
				       object.loggedin(pojo.getAccountNo(), pojo.getPassword(),pojo.getBalance());
					   break;
					    
			case "3":  System.exit(0);
			}
		}while(true);
	}
}

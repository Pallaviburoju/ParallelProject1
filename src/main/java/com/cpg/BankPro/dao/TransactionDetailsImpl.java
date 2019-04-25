package com.cpg.BankPro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cpg.BankPro.dto.Customerpojo;
import com.cpg.BankPro.utility.Database;

public class TransactionDetailsImpl implements ITransactionDetails{
	Database data=new Database();
	Customerpojo dto=new Customerpojo();
	Connection con=data.connect();
	
	public int deposit(int accountNo,int amountTransferred,int balance) {
		int res = 0;
		try {
			System.out.println(accountNo);
			System.out.println(amountTransferred);
			System.out.println(balance);
			balance=balance+amountTransferred;
			System.out.println("updated "+balance);
			dto.setBalance(balance);
			System.out.println("balance is "+dto.getBalance());
			PreparedStatement ps3=con.prepareStatement("Update customer_details set balance=? where account_no=?");
			ps3.setInt(1,balance);
			ps3.setInt(2, accountNo);
			int i=ps3.executeUpdate();
		    System.out.println("update "+i);
			
			System.out.println("deposited amount "+dto.getBalance());
		
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		return dto.getBalance();
		
	}

	public int withdraw(int accountNo,int amountTransferred,int balance) {
		
		int result=0,c=0;
		if(amountTransferred < balance) {
			balance=balance-amountTransferred;
			dto.setBalance(balance);
			try {
			PreparedStatement ps4 = con.prepareStatement("update customer_details set balance=? where account_no=?");
			ps4.setInt(1, balance);
			ps4.setInt(2, accountNo);
			int rs4=ps4.executeUpdate();
			 System.out.println("Amount after Withdraw"+balance);
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c++;
		}
		
	
		if(c==0) {
			return 0;
		}
		else {
			return balance;
		}
		
	}

	public Customerpojo fundTransfer(Customerpojo pojo) {
		int c = 0;
		int amt = pojo.getAmountTransferred();
		System.out.println("amt"+amt);
		int fromBal = 0, toBal = 0, fromAcc = 0, toAcc = 0, transid = 0;
		try {
			PreparedStatement ps6 = con.prepareStatement("select * from customer_details where account_no=? ");
			ps6.setInt(1, pojo.getFromAccountNo());
			ResultSet rs6 = ps6.executeQuery();
			while (rs6.next()) {
				fromAcc = rs6.getInt(1);
				fromBal = rs6.getInt(10);
			}
			PreparedStatement ps7 = con.prepareStatement("select * from customer_details where account_no=? ");
			ps7.setInt(1, pojo.getToAccountNo());
			ResultSet rs7 = ps7.executeQuery();
			while (rs7.next()) {
				toAcc = rs7.getInt(1);
				toBal = rs7.getInt(10);
			}

            	if (amt < fromBal) {
				fromBal = fromBal - amt;
				toBal = toBal + amt;
				PreparedStatement ps8 = con
						.prepareStatement("insert into transaction_details values(trans.nextval,?,?,?)");
				ps8.setInt(1, fromAcc);
				ps8.setInt(2, toAcc);
				ps8.setInt(3, amt);
				int x = ps8.executeUpdate();
				
				System.out.println("fundupdate "+x);
				
				if(x==1) {
					System.out.println("fund"+ pojo.getAccountNo());
					PreparedStatement ps11 = con.prepareStatement("select transaction_id from transaction_details where from_account_no=? and to_account_no=?");
					ps11.setInt(1, pojo.getFromAccountNo());
					ps11.setInt(2, pojo.getToAccountNo());

					ResultSet rs11 = ps11.executeQuery();
					while (rs11.next()) {
						transid=pojo.setTransactionId(rs11.getInt(1));
					}
				}
				System.out.println("in dao "+transid);
					if (x == 1) {
						System.out.println("here");
						PreparedStatement ps9 = con
								.prepareStatement("update customer_details set balance= ? where account_no=?");
						ps9.setLong(1, fromBal);
						ps9.setLong(2, fromAcc);
						ps9.executeUpdate();
	
						PreparedStatement ps10 = con
								.prepareStatement("update customer_details set balance= ? where account_no=?");
						ps10.setInt(1, toBal);
						ps10.setInt(2, toAcc);
						ps10.executeUpdate();
	
						pojo.setAmountTransferred(amt);
						pojo.setFromAccountNo(fromAcc);
						pojo.setToAccountNo(toAcc);
	
					}
				c++;
	           }
            	
		} catch (Exception e) {
			e.printStackTrace();
		} 
		if(c!=0)
		return pojo;
		else 
			return null;
	}


	public int showBalance(int balance) {
		return balance;
	}

}

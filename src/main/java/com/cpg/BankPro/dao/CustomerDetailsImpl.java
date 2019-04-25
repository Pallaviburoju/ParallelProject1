package com.cpg.BankPro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cpg.BankPro.dto.Customerpojo;
import com.cpg.BankPro.utility.Database;
import com.cpg.BankPro.utility.DatanotUpdatedInTableException;
import com.cpg.BankPro.utility.LoginException;


public class CustomerDetailsImpl implements ICustomerDetails{
	
	Database data=new Database();
	Customerpojo dto=new Customerpojo();
	
	public Customerpojo registration(Customerpojo pojo) {
		Connection con=data.connect();
        int accno = 0,bal=0;	
		try {
		PreparedStatement ps=con.prepareStatement
				("insert into customer_details (account_no,first_name,last_name,email_id,password,pancard_no,aadhar_no,address,mobile_no)"
						+ "values(account_no_seq.nextval,?,?,?,?,?,?,?,?)");
		
		ps.setString(1, pojo.getFirstName());
		ps.setString(2, pojo.getLastName());
		ps.setString(3, pojo.getEmailId());
		ps.setString(4, pojo.getPassword());
		ps.setString(5, pojo.getPancardNo());
		ps.setString(6, pojo.getAadharNo());
		ps.setString(7, pojo.getAddress());
		ps.setString(8, pojo.getMobileNo());
		
	    int rs=ps.executeUpdate();
	    System.out.println(rs);
	   
		if(rs==1) {
			
			PreparedStatement ps1 = con.prepareStatement("select account_no,balance from customer_details where aadhar_no=?");
			ps1.setString(1, pojo.getAadharNo());
			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {
				accno=pojo.setAccountNo(rs1.getInt(1));	
				bal=pojo.setBalance(rs1.getInt(2));
			}
		}else
		{
			throw new DatanotUpdatedInTableException();
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("in dao "+accno);
		
		return pojo;
	}

	
	
	public Customerpojo login(int accountNo,String password) {
	
		Connection con=data.connect();
		PreparedStatement ps2;
		dto.setAccountNo(accountNo);
		dto.setPassword(password);

		try {
			ps2 = con.prepareStatement("select * from customer_details where account_no=?");
		
			ps2.setInt(1,accountNo);
		ResultSet rs2=ps2.executeQuery();
		while(rs2.next()) {
			   System.out.println( "In condition"+password+" "+accountNo+" "+rs2.getInt(10));

			if(password.equals(rs2.getString(5)) && accountNo==rs2.getInt(1)) {

				dto.setAccountNo(rs2.getInt(1));
				dto.setAccountNo(rs2.getInt(1));
				dto.setFirstName(rs2.getString(2));
				dto.setLastName(rs2.getString(3));
		        dto.setEmailId(rs2.getString(4));
			    dto.setPassword(rs2.getString(5));
				dto.setPancardNo(rs2.getString(6));
				dto.setAadharNo(rs2.getString(7));
		        dto.setAddress(rs2.getString(8));
				dto.setMobileNo(rs2.getString(9));
			    dto.setBalance(rs2.getInt(10));
			}
			else {
				throw new LoginException();
			}
		}
		con.close();
	}		

	catch (Exception e) {
		e.printStackTrace();
	}
		
		return dto;
	}
	
}



	



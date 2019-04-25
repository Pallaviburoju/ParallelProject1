
package com.cpg.BankPro.service;

import com.cpg.BankPro.dao.CustomerDetailsImpl;
import com.cpg.BankPro.dao.ICustomerDetails;
import com.cpg.BankPro.dto.Customerpojo;
import com.cpg.BankPro.utility.IncorrectAadharException;

public class CustomerServiceImpl implements ICustomerService{

	Customerpojo pojo=new Customerpojo();
	ICustomerDetails dao=new CustomerDetailsImpl();
	
	public Customerpojo registration(Customerpojo pojo) {
		
		//aadhar validation
		if(pojo.getAadharNo().length()!=12) {
			
			try {
				throw new IncorrectAadharException();
			} catch (IncorrectAadharException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return dao.registration(pojo);
	}
	
	
	public Customerpojo login(int accountNo,String password) {
		pojo=dao.login(accountNo, password);
		return pojo;
	}


	


	

}

package com.cpg.BankPro.dao;

import com.cpg.BankPro.dto.Customerpojo;

public interface ICustomerDetails {
	
	Customerpojo registration(Customerpojo pojo);
	Customerpojo login(int accountNo,String password);
	
	
}

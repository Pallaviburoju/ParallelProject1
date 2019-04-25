package com.cpg.BankPro.service;

import com.cpg.BankPro.dto.Customerpojo;

public interface ICustomerService {
	Customerpojo registration(Customerpojo pojo);
	Customerpojo login(int accountNo,String password);
	


	
}

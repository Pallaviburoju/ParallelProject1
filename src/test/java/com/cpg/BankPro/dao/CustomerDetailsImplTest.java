package com.cpg.BankPro.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cpg.BankPro.dto.Customerpojo;

class CustomerDetailsImplTest {
	
	
		Customerpojo pojo=new Customerpojo();
		CustomerDetailsImpl dao=new CustomerDetailsImpl();
	
	@Test
	void testRegistration() {
		pojo.setFirstName("pal");
		pojo.setLastName("Buroju");
		pojo.setEmailId("pal@");
		pojo.setPassword("pallavi");
		pojo.setPancardNo("20");
	    pojo.setAadharNo("987654321234");
		pojo.setAddress("hyd");
	    pojo.setMobileNo("7382303065");
		
		assertEquals(pojo,dao.registration(pojo));
	}

	@Test
	void testLogin() {
		//pojo.setAccountNo(74);
		//pojo.setPassword("pallavi");
		pojo=dao.login(1001, "123");
		assertEquals(pojo,pojo);
	}

}

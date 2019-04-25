package com.cpg.BankPro.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	public Connection connect() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","PALLAVI","Oracle1pass");
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return connection;
		
	}
}

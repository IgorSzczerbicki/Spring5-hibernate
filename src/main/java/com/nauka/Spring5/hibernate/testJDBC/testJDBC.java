package com.nauka.Spring5.hibernate.testJDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class testJDBC {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-one-to-one-uni?useSSL=false&allowPublicKeyRetrieval=true";
		String user = "hbstudent";
		String pass = "hbstudent";
		try {
			Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Conected");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
package com.Surethan.ElectronicShop;

import java.sql.Connection;
import java.sql.DriverManager;

public class ElectronicShopDB {
	public Connection getDBConnection() {
		Connection con=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop","Surethan","GreenWorld[$S37]");
		}catch(Exception e) {
		System.out.println(e);
		}
		return con;
		}
}

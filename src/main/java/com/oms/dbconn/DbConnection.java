package com.oms.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	public static Connection getConnection() {
		
	Connection con = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/adminportal";
		String uname="root";
		String pwd="SFG117V";
		con= DriverManager.getConnection(url,uname,pwd);	
	}
	catch(Exception ex){
		ex.printStackTrace();
	}
	
	return con;
	
	}
}

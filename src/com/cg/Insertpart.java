package com.cg;

import java.sql.SQLException;
import java.sql.Statement;

public class Insertpart {
 static void testconten(int id,String account,String password) {
		
		
		//执行 
		try {
			
			String sql="insert into account(id,name,passwords)"+ "values("+ id +",'" + account +"','"+password+"')";
			Statement  statement =Connect.getconnection().createStatement();
			int rows= statement.executeUpdate(sql);
			System.out.println("所影响的行数为"+rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}

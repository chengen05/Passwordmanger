package com.cg;

import java.sql.SQLException;
import java.sql.Statement;

public class Insertpart {
 static void testconten(int id,String account,String password) {
		
		
		//ִ�� 
		try {
			
			String sql="insert into account(id,name,passwords)"+ "values("+ id +",'" + account +"','"+password+"')";
			Statement  statement =Connect.getconnection().createStatement();
			int rows= statement.executeUpdate(sql);
			System.out.println("��Ӱ�������Ϊ"+rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}

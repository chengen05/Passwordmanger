package com.cg;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

 class Deletedata {
	static void deletedata(int id) {
		Statement statement=null;
		Connection connectiontest=null;
			try {
			
				String deldata="delete from account where id="+ id ;
				connectiontest=Connect.getconnection();
				 statement = Connect.getconnection().createStatement();
				int rows= statement.executeUpdate(deldata);
				System.out.println("所删除的行数为"+rows);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				Allclose.allclose(statement,connectiontest,null);
			}
	}
}

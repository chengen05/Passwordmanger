package com.cg;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 class Allclose {

	static void allclose(Statement address,Connection addresscon,ResultSet resultSet) {
		System.out.println("进入释放连接函数");
		try {
			if(address !=null) 
			{
				address.close();
			}
			if(addresscon !=null)
			{
			addresscon.close();
			}
			if(resultSet !=null)
			{
				resultSet.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

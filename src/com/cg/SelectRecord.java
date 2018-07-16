package com.cg;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 class SelectRecord {
	static void select(String sqlSelectName) {
		//构建数据库连接
		String [][] datas =new String[100][3] ;
		Connection connection=Connect.getconnection();
		Statement statement=null;
		ResultSet resultset=null;
		int index=0;
		//写查询语句
		String sql="select id,name,passwords from account";
		//执行语句
		try {
			
			statement=connection.createStatement();
			resultset=statement.executeQuery(sql);
			//遍历数组
			
			
			while(resultset.next()) {
				int id = resultset.getInt("id");
				String name= resultset.getString("name");
				String passwords= resultset.getString("passwords");
				datas[index][0]=String.valueOf(id);
				datas[index][1]=name;
				datas[index][2]=passwords;
				index ++;
			}
			FindRecord.findsoucer(datas,index);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Allclose.allclose(statement,connection,resultset);
		}
		
	}
	 static void idselect(String selectname) {
		Connection connection=Connect.getconnection();
		Statement statement=null;
		ResultSet resultset=null;
		
		String [][] datas =new String[100][3] ;
		//写查询语句
		int index=0;
		String sql="select id,name,passwords from account where name like'%"+ selectname+"%'";
		
		try {
			 statement= connection.createStatement();
			 resultset =statement.executeQuery(sql);

			while(resultset.next()) {
				int idname =resultset.getInt("id");
				String name= resultset.getString("name");
				String passwords= resultset.getString("passwords");
				datas[index][0]=String.valueOf(idname);
				datas[index][1]=name;
				datas[index][2]=passwords;
				index ++;
				}
			FindRecord.findsoucer(datas,index);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			Allclose.allclose(statement,connection,resultset);
		}
		
	
	}

}

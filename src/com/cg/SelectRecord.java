package com.cg;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 class SelectRecord {
	static void select(String sqlSelectName) {
		//�������ݿ�����
		String [][] datas =new String[100][3] ;
		Connection connection=Connect.getconnection();
		Statement statement=null;
		ResultSet resultset=null;
		int index=0;
		//д��ѯ���
		String sql="select id,name,passwords from account";
		//ִ�����
		try {
			
			statement=connection.createStatement();
			resultset=statement.executeQuery(sql);
			//��������
			
			
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
		//д��ѯ���
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

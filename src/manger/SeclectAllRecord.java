package manger;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SeclectAllRecord {
	static void selectallrecord() {
		String [][] datas =new String[100][5] ;
		int index=0;
		String sql="select id,book_name,book_publisher,book_auther,create_time from library";
		try {
			
			Statement statement=Connectdata.connectdata().createStatement();
			ResultSet resultset=statement.executeQuery(sql);
			
			while(resultset.next()) {
				int id = resultset.getInt("id");
				String name= resultset.getString("book_name");
				String publisher= resultset.getString("book_publisher");
				String auther= resultset.getString("book_auther");
				String  data= String.valueOf(resultset.getTimestamp("create_time"));
				datas[index][0]=String.valueOf(id);
				datas[index][1]=name;
				datas[index][2]=publisher;
			
				datas[index][3]=auther;
			
				datas[index][4]=data;
				
				index ++;
			
			}
				
				FindRecord.findsoucer(datas, index);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}


package manger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class SeclectRecord {
static void	seclectRecord(){
	Connection connection=Connectdata.connectdata();
	Scanner scanner=new Scanner(System.in);
	String username=scanner.next();
	String [][] datas =new String[1000][5] ;
	//–¥≤È—Ø”Ôæ‰
	int index=0;
	String sql="select id,book_name,book_publisher,book_auther,creat_time from account where book_name like'%"+ username+"%'";
	
	try {
		 Statement statement= connection.createStatement();
		 ResultSet resultset =statement.executeQuery(sql);

		while(resultset.next()) {
			int id = resultset.getInt("id");
			String name= resultset.getString("book_name");
			String publisher= resultset.getString("book_publisher");
			String auther= resultset.getString("book_auther");
			java.sql.Timestamp data= resultset.getTimestamp("creat_time");
			datas[index][0]=String.valueOf(id);
			datas[index][1]=name;
			datas[index][2]=publisher;
			datas[index][3]=auther;
			datas[index][4]=String.valueOf(data);
			index ++;
		}
			for(int i=0;i<index;i++)
			{
				for(int j=0;j<5;j++) {
					System.out.print(datas[i][j]+"  ");
				}
				System.out.println();
			}
			
		FindRecord.findsoucer(datas, index);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
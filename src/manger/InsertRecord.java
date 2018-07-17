package manger;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertRecord {
static void insertrecord() {
		Scanner scanner=new Scanner(System.in);
		String value=scanner.next();
		String values[]=value.split(",");
		int id=Integer.parseInt(values[0]);
		try {
			
			String sql="insert into library(id,book_name,book_publisher,)"+ "values("+ id +",'" + values[1] +"','"+values[2]+"')";
			Statement  statement =Connectdata.connectdata().createStatement();
			int rows= statement.executeUpdate(sql);
			System.out.println("更新成功，更新了"+rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

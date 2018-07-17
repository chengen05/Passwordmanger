package manger;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class DelRecord {
	static void delRecord() {
		Scanner scanner=new Scanner(System.in);
		int id=scanner.nextInt();
		try {
			
			String deldata="delete from account where id="+ id ;
			
			Statement statement = Connectdata.connectdata().createStatement();
			int rows= statement.executeUpdate(deldata);
			System.out.println("所删除的行数为"+rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

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
			System.out.println("��ɾ��������Ϊ"+rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

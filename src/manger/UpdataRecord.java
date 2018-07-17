package manger;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class UpdataRecord {
	static void updata() {
		Scanner scanner=new Scanner(System.in);
		String value=scanner.next();
		String values[]=value.split(",");
		int id=Integer.parseInt(values[1]);
		try {
			
			String sql="update account set passwords='"+ values[0] +"'where id="+ id;
			Statement statement = Connectdata.connectdata().createStatement();
			int rows=statement.executeUpdate(sql);
			System.out.println("更新了"+rows+"条，数据");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}


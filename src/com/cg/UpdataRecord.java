package com.cg;

import java.sql.SQLException;
import java.sql.Statement;

class UpdataRecord {
static void updata(int setwhere,String newpass) {
		
		
		try {
			
			String updata1="update account set passwords='"+ newpass +"'where id="+ setwhere;
			Statement statement = Connect.getconnection().createStatement();
			int rows=statement.executeUpdate(updata1);
			System.out.println("更新了"+rows+"条，数据");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

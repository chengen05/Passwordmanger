package manger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Connectdata {
 static	Connection connectdata() {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		String dburl="jdbc:mysql://127.0.0.1:3306/first";
		try {
			java.sql.Connection  connection=DriverManager.getConnection(dburl,"root","root");
			return connection;
		}catch(SQLException e) {
			e.printStackTrace();		
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	return null;
	}
}

package cj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCutil {
		public static Connection getConnection() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String dburl="jdbc:mysql://127.0.0.1:3306/first";
				try {
					java.sql.Connection  connection=DriverManager.getConnection(dburl,"root","root");
				//sql语句
				
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
		
		
		static void allclose(Statement address,Connection addresscon,ResultSet resultSet) {
			System.out.println("进入释放连接函数");
			try {
				if(address !=null) 
				{
					address.close();
				}
				if(addresscon !=null)
				{
				addresscon.close();
				}
				if(resultSet !=null)
				{
					resultSet.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}


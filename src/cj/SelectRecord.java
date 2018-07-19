package cj;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 class SelectRecord {
	static String[][] select() {
		//构建数据库连接
		String [][] datas =new String[9999][4] ;
		Connection connection=JDBCutil.getConnection();
		Statement statement=null;
		ResultSet resultset=null;
		String[][] savein=new String[9999][4];	
		int index=0;
		//写查询语句
		String sql="select id,name,passwords,data from passdatas";
		//执行语句
		try {
			
			statement=connection.createStatement();
			resultset=statement.executeQuery(sql);
			//遍历数组
			
			
			while(resultset.next()) {
				int id = resultset.getInt("id");
				String name= resultset.getString("name");
				String passwords= resultset.getString("passwords");
				String  data= String.valueOf(resultset.getTimestamp("data"));
				datas[index][0]=String.valueOf(id);
				datas[index][1]=name;
				datas[index][2]=passwords;
				datas[index][3]=data;
				index ++;
			}
				WriteInArrary writein=new WriteInArrary();
				savein=writein.writeInArrary(datas, index);
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCutil.allclose(statement,connection,resultset);
		}
		return savein;
		
	}
	 static String[][] nameselect(String selectname) {
		Connection connection=JDBCutil.getConnection();
		Statement statement=null;
		ResultSet resultset=null;
		String[][] savein=null;	
		String [][] datas =new String[9999][4] ;
		//写查询语句
		int index=0;
		String sql="select id,name,passwords,data from passdatas where name like'%"+ selectname+"%'";
		
		try {
			 statement= connection.createStatement();
			 resultset =statement.executeQuery(sql);

			while(resultset.next()) {
				int idname =resultset.getInt("id");
				String name= resultset.getString("name");
				String passwords= resultset.getString("passwords");
				String  data= String.valueOf(resultset.getTimestamp("data"));
				datas[index][0]=String.valueOf(idname);
				datas[index][1]=name;
				datas[index][2]=passwords;
				datas[index][3]=data;
				index ++;
				}
			WriteInArrary writein=new WriteInArrary();
			savein=writein.writeInArrary(datas, index);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			JDBCutil.allclose(statement,connection,resultset);
		}
		
	return savein;
	}

}

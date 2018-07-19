package cj;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectionDao {
	int connection(String sql) {
		Connection connect=JDBCutil.getConnection();
		Statement statement=null;
		try {
			statement=connect.createStatement();
			int rows=statement.executeUpdate(sql);
			return rows;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCutil.allclose(statement, connect, null);
		
		}
		return 0;
	
}
 public List<Object> query(String sql) {
	 Connection connect=JDBCutil.getConnection();
		Statement statement=null;
		ResultSet resultSet=null;
		List<Object> datas=new ArrayList<>();
		 try {
			statement=connect.createStatement();
			resultSet=statement.executeQuery(sql);
			ResultSetMetaData metaData=resultSet.getMetaData();
			int column=metaData.getColumnCount();//�õ�����
			while(resultSet.next()) {
				Object[] columnDatas=new Object[column];
				for(int i=0;i<columnDatas.length;i++) {
					columnDatas[i]=resultSet.getObject(i+1);//resultset�������Ǵ�1��ʼ��
				}
				datas.add(columnDatas);//������ݵ�����
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	return datas;	 
 }
}
package cj;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.sql2o.Sql2o;
import znzz.cg.WriteInArrary;





public class AccountDao extends ConnectionDao {
	 public int delete(int id)  {	
		String deldata="delete from passdatas where id="+ id;
		return super.connection(deldata);	
	 }
	 
	 public int updata(Account account) {	
		String updata1="update passdatas set passwords='"+ account.getPasswords() +"'where id="+ account.getId();
		return super.connection(updata1);	
	 }
	 
	 public int insert(Account account) {
			String sql="insert into passdatas(name,passwords)"+ "values('" + account.getName() +"','"+account.getPasswords()+"')";
			return super.connection(sql);	
	 }
	 
	 public List<Account> findAll(){
		 //¡¨Ω” ˝æ›ø‚
//		 String sql="select id,name,passwords,data from passdatas";
//		 Sql2o sql2o=new Sql2o(sql,"root","root");
//		 Connection conn=null;
//		 conn=sql2o.open();
	
		
	
		
			//–¥≤È—Ø”Ôæ‰
		String sql="select id,name,passwords,data from passdatas";
			//÷¥––”Ôæ‰
		List<Object> list=super.query(sql);
		List<Account> accountList=new ArrayList<>();
		for(Object data:list) {
			Object [] d= (Object[]) data;
			Account account=new Account();
			account.setId(Integer.parseInt(d[0]+""));
			account.setName(d[1]+"");
			account.setPasswords(d[2]+"");
			account.setData(d[3]+"");
			accountList.add(account);
		}
		return accountList;
		

	 }
	 public List<Account> findById(int id) {
		 
		
			//–¥≤È—Ø”Ôæ‰
		
			String sql="select id,name,passwords,data from passdatas where id ="+ id;
			List<Object> list=super.query(sql);
			List<Account> accountList=new ArrayList<>();
			for(Object data:list) {
				Object [] d= (Object[]) data;
				Account account=new Account();
				account.setId(Integer.parseInt(d[0]+""));
				account.setName(d[1]+"");
				account.setPasswords(d[2]+"");
				account.setData(d[3]+"");
				accountList.add(account);
			}
			return accountList;
			
	
	 }
	 public List<Account> findByKeyword(String keyword) {
//		 List<Account> list = new ArrayList<>();
			
//		 Connection connection=JDBCutil.getConnection();
//			Statement statement=null;
//			ResultSet resultset=null;
			
			//–¥≤È—Ø”Ôæ‰
			String sql="select * from passdatas where name like'%"+ keyword+"%'";
			List<Object> list=super.query(sql);
			List<Account> accountList=new ArrayList<>();
			for(Object data:list) {
				Object [] d= (Object[]) data;
				Account account=new Account();
				account.setId(Integer.parseInt(d[0]+""));
				account.setName(d[1]+"");
				account.setPasswords(d[2]+"");
				account.setData(d[3]+"");
				accountList.add(account);
			}
			return accountList;
//			
			
		
//			try {
//				 statement= connection.createStatement();
//				 resultset =statement.executeQuery(sql);
//				while(resultset.next()) {
//					Account acc=new  Account();
//					int idname =resultset.getInt("id");
//					String name= resultset.getString("name");
//					String passwords= resultset.getString("passwords");
//					String  data= String.valueOf(resultset.getTimestamp("data"));
//					acc.setId(idname);
//					acc.setName(name);
//					acc.setPasswords(passwords);
//					acc.setData(data);
//					list.add(acc);
//					
//					}
//			
//				
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}finally {
//			
//				JDBCutil.allclose(statement,connection,resultset);
//			}
//			
//		
//			
//		   return list;
	 }
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
			AccountDao accountdao=new AccountDao();
			//System.out.println(accountdao.findById(7));
			System.out.println(accountdao.findAll());
			System.out.println(accountdao.findByKeyword("c"));
		}
}

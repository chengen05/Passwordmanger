package first.one;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
// �������ݿ�����
//�������ݿ�sql���
//ִ��sql���
//
public class Jbdc {
	private java.sql.Connection getconnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://127.0.0.1:3306/first";
			try {
			java.sql.Connection connection=DriverManager.getConnection(dburl,"root","root");
			//sql���
			
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
	private void testconten(int id,String account,String password) {
		
		
		//ִ�� 
		try {
			
			String sql="insert into account(id,name,passwords)"+ "values("+ id +",'" + account +"','"+password+"')";
			Statement  statement =getconnection().createStatement();
			int rows= statement.executeUpdate(sql);
			System.out.println("��Ӱ�������Ϊ"+rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	//ɾ������
	private void deletedata(int id) {
		
			
			try {
			
				String deldata="delete from account where id="+ id ;
				Statement statement = getconnection().createStatement();
				int rows= statement.executeUpdate(deldata);
				System.out.println("��ɾ��������Ϊ"+rows);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	private void createtable(int setwhere,String newpass) {
		
		
		try {
			
			String updata1="update account set passwords='"+ newpass +"'where id="+ setwhere;
			Statement statement = getconnection().createStatement();
			int rows=statement.executeUpdate(updata1);
			System.out.println(rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Jbdc xy=new Jbdc();
		//xy.testconten(270,"yahu","789456");
		//xy.deletedata(7);
		//xy.createtable(270,"9527");
		Scanner scanner=new Scanner(System.in);
	while(true)
		{	
		System.out.println("============================================");
		System.out.println(" [              �˹�����                                                ]");
		System.out.println("============================================");
		System.out.println("[1.���          2.ɾ��                 3.�޸�              4.�˳�                 ]");
		System.out.println("���������ѡ��");
		
		int select=scanner.nextInt();
		while(select >5 || select <0)
		{
			System.out.println("���������������");
			select=scanner.nextInt();
		}
		Jbdc newjbdc=new Jbdc();
		String value=null;
		switch(select) {
		case 1:
			{
			System.out.println("��������Ҫ��ӵ��˺ź����룬�ö��Ÿ���");
			value=scanner.next();
			String [] values= value.split(",");
			newjbdc.testconten((int)System.currentTimeMillis(), values[0], values[1]);
			break;
			}
		case 2:
			{
				System.out.println("��������Ҫɾ����id");
				int valueid=scanner.nextInt();
				newjbdc.deletedata(valueid);
				break;
			}
		case 3:
			{
				System.out.println("��������Ҫ�޸ĵ����ݣ�id+password");
				value=scanner.next();
				String [] values= value.split(",");
				newjbdc.createtable(Integer.parseInt(values[0]), values[1]);
				break;
			}
		case 4:
			{
				System.out.println("�˳�ϵͳ");
				System.exit(-1);
				
			}
		}
		}
	}
}

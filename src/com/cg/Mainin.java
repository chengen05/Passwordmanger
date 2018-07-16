package com.cg;

import java.util.Scanner;

public class Mainin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
	while(true)
		{	
		System.out.println("=========  =============================  ======");
		System.out.println(" [                  人工智能                                                  ]");
		System.out.println("=========  =============================  ======");
		System.out.println("[1.添加          2.删除         3.修改             4.选择           5.退出           ]");
		System.out.println("请输入你的选择");
		
		int select=0;
			select=	scanner.nextInt();
		while(select >5 || select <0)
		{
			System.out.println("输入错误，重新输入");
			select=scanner.nextInt();
		}
		
		String value=null;
		switch(select) {
		case 1:
			{
			System.out.println("请输入你要添加的账号和密码，用逗号隔开");
			value=scanner.next();
			String [] values= value.split(",");
			Insertpart.testconten((int)System.currentTimeMillis(), values[0], values[1]);
			break;
			}
		case 2:
			{
				System.out.println("请输入你要删除的id");
				int valueid=scanner.nextInt();
				Deletedata.deletedata(valueid);
				break;
			}
		case 3:
			{
				System.out.println("请输入你要修改的数据，id+password");
				value=scanner.next();
				String [] values= value.split(",");
				UpdataRecord.updata(Integer.parseInt(values[0]), values[1]);
				break;
			}
		case 4:
			{
				System.out.println("请输入你要查询的名字");
				String selectname =scanner.next();
				SelectRecord.idselect(selectname);
				break;
				
			}
		case 5:
			{
				
				System.out.println("退出系统");
				System.exit(-1);
				break;
			}
		}
		}
	}

}

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
		System.out.println(" [                  �˹�����                                                  ]");
		System.out.println("=========  =============================  ======");
		System.out.println("[1.���          2.ɾ��         3.�޸�             4.ѡ��           5.�˳�           ]");
		System.out.println("���������ѡ��");
		
		int select=0;
			select=	scanner.nextInt();
		while(select >5 || select <0)
		{
			System.out.println("���������������");
			select=scanner.nextInt();
		}
		
		String value=null;
		switch(select) {
		case 1:
			{
			System.out.println("��������Ҫ��ӵ��˺ź����룬�ö��Ÿ���");
			value=scanner.next();
			String [] values= value.split(",");
			Insertpart.testconten((int)System.currentTimeMillis(), values[0], values[1]);
			break;
			}
		case 2:
			{
				System.out.println("��������Ҫɾ����id");
				int valueid=scanner.nextInt();
				Deletedata.deletedata(valueid);
				break;
			}
		case 3:
			{
				System.out.println("��������Ҫ�޸ĵ����ݣ�id+password");
				value=scanner.next();
				String [] values= value.split(",");
				UpdataRecord.updata(Integer.parseInt(values[0]), values[1]);
				break;
			}
		case 4:
			{
				System.out.println("��������Ҫ��ѯ������");
				String selectname =scanner.next();
				SelectRecord.idselect(selectname);
				break;
				
			}
		case 5:
			{
				
				System.out.println("�˳�ϵͳ");
				System.exit(-1);
				break;
			}
		}
		}
	}

}

package manger;

import java.util.Scanner;

public class Librarymange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		while(true) {
		System.out.println("=========================================================");
		System.out.println("----------------------ͼ�����ϵͳ 1.0-----------------------");
		System.out.println("=========================================================");
		System.out.println("1.����鼮    2.�޸��鼮   3.ɾ���鼮   4.��ѯ�����鼮   5.ѡ���ѯ   6.�˳�ϵͳ");
		System.out.println("���������ѡ��");
		
			int change=scanner.nextInt();
			while(change<1 || change>6)
			{
				System.out.println("��������ٴ�ѡ��");
				change=scanner.nextInt();
			}
			switch(change) {
			case 1:
				System.out.println("����鼮������id,�鼮����������");
				InsertRecord.insertrecord();
				break;
			case 2:
				System.out.println("��������Ҫ�޸ĵ��鼮��������Ϊid");
				UpdataRecord.updata();
				break;
			case 3:
				System.out.println("��������Ҫɾ����id");
				DelRecord.delRecord();
				break;
			case 4:
				System.out.println("��ѯ��������");
				SeclectAllRecord.selectallrecord();
				break;
			case 5:
				System.out.println("ѡ���ѯ,����");
				SeclectRecord.seclectRecord();
				break;
			case 6:
				System.out.println("�˳�ϵͳ");
				System.exit(-1);
				break;
				
			}
		}
	}

}

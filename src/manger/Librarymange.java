package manger;

import java.util.Scanner;

public class Librarymange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		while(true) {
		System.out.println("=========================================================");
		System.out.println("----------------------图书管理系统 1.0-----------------------");
		System.out.println("=========================================================");
		System.out.println("1.添加书籍    2.修改书籍   3.删除书籍   4.查询所有书籍   5.选择查询   6.退出系统");
		System.out.println("请输入你的选择");
		
			int change=scanner.nextInt();
			while(change<1 || change>6)
			{
				System.out.println("输入错误，再次选择");
				change=scanner.nextInt();
			}
			switch(change) {
			case 1:
				System.out.println("添加书籍请输入id,书籍名，出版社");
				InsertRecord.insertrecord();
				break;
			case 2:
				System.out.println("请输入你要修改的书籍名，条件为id");
				UpdataRecord.updata();
				break;
			case 3:
				System.out.println("请输入你要删除的id");
				DelRecord.delRecord();
				break;
			case 4:
				System.out.println("查询所有数据");
				SeclectAllRecord.selectallrecord();
				break;
			case 5:
				System.out.println("选择查询,姓名");
				SeclectRecord.seclectRecord();
				break;
			case 6:
				System.out.println("退出系统");
				System.exit(-1);
				break;
				
			}
		}
	}

}

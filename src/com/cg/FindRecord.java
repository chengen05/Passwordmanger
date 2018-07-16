package com.cg;

class FindRecord {
	//二位数组输出
		static void findsoucer(String [][]datas,int index) {
			StringBuffer buffer=new StringBuffer();
			buffer.append("=============================="+System.lineSeparator());
			buffer.append("id\t\t\tname\t\t\tpasswords\t\t\t"+System.lineSeparator());
			buffer.append("=============================="+System.lineSeparator());
			for(int i=0;i<index;i++)
			{
				for(int j=0;j<=2;j++)
				{
					System.out.print(datas[i][j]+"   ");
				}
				System.out.println();
			}
			
		}
}

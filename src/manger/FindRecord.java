package manger;

class FindRecord {
	//��λ�������
		static void findsoucer(String [][]datas,int index) {
		
			for(int i=0;i<index;i++)
			{
				for(int j=0;j<=4;j++)
				{
					System.out.print(datas[i][j]+"   ");
				}
				System.out.println();
			}
			
		}
}

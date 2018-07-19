package cj;

public class WriteInArrary {
		String[][]	writeInArrary(String[][]datas,int index ){
				String[][] values=new String[index][4];
				for(int i=0;i<index;i++)
				{
					for(int j=0;j<4;j++)
					{
						values[i][j]=datas[i][j];
					}
				}
			return values;	
			}
}

public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer>list=new ArrayList<Integer>();
		list.add(1);
		for(int i=1;i<=rowIndex;i++)
		{
			for(int j=i;j>0;j--)
			{
				if(i==j)list.add(1);
				else list.set(j, list.get(j)+list.get(j-1));
			}
		}
		return list; 
    }
}
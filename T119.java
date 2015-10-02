package excise;

import java.util.ArrayList;

public class T119 {
	
	public static ArrayList<Integer> getRow(int rowIndex) 
	{
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        for (int i = 1; i <= rowIndex; i++) 
        {
            for(int j = i; j>0; j--)
            {
                if(i == j) list.add(1);
                else
                {
                    list.set(j,list.get(j)+list.get(j-1));
                }
            }
			
		}
        return list;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list =getRow(5);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}

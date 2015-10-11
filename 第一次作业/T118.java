package excise;
import java.util.ArrayList;
public class T118 {
	 public static ArrayList<ArrayList<Integer>> generate(int numRows) 
	 {
		 ArrayList<ArrayList<Integer>> vecvecRes = new ArrayList<ArrayList<Integer>>();
		 if (numRows==1) 
		 {
			 ArrayList<Integer> list = new ArrayList<Integer>();
			 list.add(1);
			 vecvecRes.add(list);
		 }
		 if (numRows>=2) 
		 {
			 for (int i = 0; i < 2; i++) 
			 {
				 ArrayList<Integer> list = new ArrayList<Integer>();
				 for (int j = 0; j <= i; j++) 
				 {
					 list.add(1);
				 }
				 vecvecRes.add(list);
			 }
		 }
		 for (int i = 2; i < numRows; i++) 
		 {
			 ArrayList<Integer> list = new ArrayList<Integer>();
			 ArrayList<Integer> upList = vecvecRes.get(i - 1);//list也是从0开始的下标
			 list.add(1);
			 for (int j = 1; j < i; j++) 
			 {
				list.add(upList.get(j-1)+upList.get(j));
			 }
			 list.add(1);
			 vecvecRes.add(list);
		 }
		 
	     return vecvecRes;   
	 }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generate(3);
	}
}

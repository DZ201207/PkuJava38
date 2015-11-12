package excise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class T18 {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		if (nums.length<=3) {
			return lists;
		}
		Arrays.sort(nums);
		HashSet<ArrayList<Integer>> hashSet=new HashSet<ArrayList<Integer>>();
		for (int i = 0; i < nums.length; i++) 
		{
			for (int j = i+1; j < nums.length; j++) 
			{
				int head=j+1;
				int tail=nums.length-1;
				while (head<tail) {
				   int	item = nums[i]+nums[j]+nums[head]+nums[tail];
				   if (item>target) tail--;
				   else if(item<target) head++;
				   else {
					   ArrayList<Integer> list = new ArrayList<Integer>();
					   list.add(nums[i]);
					   list.add(nums[j]);
					   list.add(nums[head]);
					   list.add(nums[tail]);
					   if (!hashSet.contains(list)) {
						   hashSet.add(list);
						   lists.add(list);
					   }
					   tail--;
					   head++;
				   }
				}
			}
		}
		
//		for (int i = 0; i < lists.size(); i++) {
//			for (int j = 0; j < 4; j++) {
//				System.out.print(lists.get(i).get(j)+" ");
//			}
//			System.out.println();
//		}
		
		 return lists;
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int []a={1, 0, -1, 0 ,-2, 2};
		fourSum(a,0);
	}

}

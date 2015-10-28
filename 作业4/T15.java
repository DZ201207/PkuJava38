package excise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T15 {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		if (nums.length<=2) {
			return lists;
		}
		Arrays.sort(nums);
		 for (int i = 0; i < nums.length-2; i++) 
		 {
			 if (i>0 && nums[i]==nums[i-1]) continue;
			 int head = i+1,tail=nums.length-1;
			 int target = -nums[i];
			 while (head<tail) 
			 {
				int temp = nums[head]+nums[tail]; 
				if (temp>target) tail--;
				else if (temp<target) head++;
				else {
					List<Integer> list = new ArrayList<Integer>();
					list.add(nums[i]);
					list.add(nums[head]);
					list.add(nums[tail]);
					lists.add(list);
					head++;
					do{tail--;}while(tail>=1 && nums[tail] == nums[tail+1]);
				}
			 }
		 }
		 return lists;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int []a={0,0,0};
		List<List<Integer>> lists = threeSum(a);
		System.out.println("lists size="+lists.size());
		for (int i = 0; i < lists.size(); i++) {
			//System.out.println("i="+i);
			for (int j = 0; j <3; j++) {
				//System.out.println("i,j="+i+" "+j);
				System.out.print("list[][]"+lists.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}

}

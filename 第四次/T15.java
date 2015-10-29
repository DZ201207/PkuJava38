
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ls = new ArrayList<List<Integer>>();
		if (nums.length<=2) 
		{
			return ls;
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
				else 
				{
					List<Integer> l = new ArrayList<Integer>();
					l.add(nums[i]);
					l.add(nums[head]);
					l.add(nums[tail]);
					ls.add(l);
					head++;
					do{tail--;}while(tail>=1 && nums[tail] == nums[tail+1]);
				}
			 }
		 }
		 return ls;
    }
}
package excise;

import java.util.HashMap;

public class T136 {
	 public static int singleNumber(int[] nums) {
	        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
	        for (int i = 0; i < nums.length; i++) {
				if (hashMap.get(nums[i])==null) {
					hashMap.put(nums[i], 1);
				}
				else {
					hashMap.put(nums[i], 2);
				}
			}
	        for (int i = 0; i < nums.length; i++) {
				if (hashMap.get(nums[i])==1) {
					return nums[i];
				}
			}
	        return -1;
	    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []num={1,1,2,2,0,0,3};
		System.out.println(singleNumber(num));
	}

}

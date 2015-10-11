package excise;

import java.util.HashMap;

public class T1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer>  table = new HashMap<Integer, Integer>();
	      int[] temp = new  int[2];
	      Integer k=0;
	      for (int i = 0; i < nums.length; i++){ 
	    	  k = table.get(target - nums[i]);
	    	  if (k == null) {
	    		  table.put(nums[i], i);
			}else {
				temp[0] = k+1;
				temp[1] = i+1;
				return temp;
			}
			
	      }
		return temp;
  }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package excise;

public class T27 {
	 	public static int removeElement(int[] nums, int val) {
	 		int count=0;
	        for (int i = 0; i < nums.length; i++) {
				if (nums[i]==val) {
					count++;
				}
				else {
					nums[i-count] = nums[i];
				}
			}
	        return nums.length-count;
	    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int nums[]={1,2,3,0,0,4,5,0,0,2};
		int k =removeElement(nums, 0);
		for (int i = 0; i < k ; i++) {
			System.out.println("nums["+i+"] = "+nums[i]);
		}

	}

}

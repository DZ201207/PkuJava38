package excise;

public class T169 {
	public static int majorityElement(int[] nums) {
		int is_majority = 0;
		int count=0;
        for (int i = 0; i < nums.length; i++) {
			if(count==0){
				is_majority = nums[i];
				count=1;
				continue;
			}
			if (is_majority==nums[i])  count++;
			else count--;
		}
        return is_majority;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,6,6,6,6,6,6,6};
		System.out.println(majorityElement(a));
	}

}

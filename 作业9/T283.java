package excise;

public class T283 {
	public static void moveZeroes(int[] nums) {
		if(nums==null) return;
		int count=0;
        for (int i = 0; i < nums.length; i++) {
			if(nums[i]==0) count++;
			else{
				nums[i-count]=nums[i];
			}
		}
        for (int i = 1; i <= count; i++) {
			nums[nums.length-i]=0;
		}
        
    }
	public static void main(String[] args) {
		int nums[] = {0, 1, 0, 3, 12};
		moveZeroes(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}

	}

}

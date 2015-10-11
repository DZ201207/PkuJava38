package excise;

public class T75 {
	
	public static void sortColors(int[] nums) {
        int k0 = 0;
        int k1 = 0;
        int k2 = 0;
        for (int i = 0; i < nums.length; i++) 
        {
			if (nums[i]==0) k0++;
			else if (nums[i]==1) k1++;
			else if (nums[i]==2) k2++;
		}
        for (int i = 0; i < k0; i++)  nums[i] = 0;
        for (int i = k0; i < k0+k1; i++)  nums[i] = 1;
        for (int i = k0+k1; i < k0+k1+k2; i++)  nums[i] = 2;
       
        for (int i = 0; i < nums.length; i++) 
        	System.out.println(nums[i]);
        
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {1,2,0,1,2,0,2,0};
		sortColors(a);
	}

}

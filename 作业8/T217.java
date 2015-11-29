package excise;

import java.util.ArrayList;
import java.util.Arrays;

public class T217 {
	public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int k = 0;
        for (int i = 0; i < nums.length-1; i++) {
			k = nums[i];
			if (k==nums[i+1]) return true;
		}
        return false;
    }
	public static void main(String[] args) {
		int a[] = {1,2,3,4,9,8,7,8};
		int b[] = {1,2,3,4,9,8,7};
		System.out.println(containsDuplicate(a));
		System.out.println(containsDuplicate(b));

	}

}

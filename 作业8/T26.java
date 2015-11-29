package excise;

public class T26 {
	public static int removeDuplicates(int[] nums) {
        int r=0;
        int temp = 0;
        for (int i = 0; i < nums.length-1; i++){
			temp = nums[i];
			if (temp==nums[i+1]) r++;
			else {
				nums[i+1-r] = nums[i+1];
			}
		}
        return nums.length-r;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={1,1,2,2,3};
		int n =removeDuplicates(a);
		for (int i = 0; i < n; i++) {
			System.out.println(a[i]);
		}
	}

}

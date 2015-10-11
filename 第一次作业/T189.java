package excise;

public class T189 {
	public static void rotate1(int[] nums, int k) 
	{
       int temp[] = new int[nums.length]; 
       int n = nums.length;
       int i;//迭代器
       int j = 0;//标记
       k = k%n;
       for ( i = 0; i < n; i++) 
    	   temp[i] = nums[i];
       for ( i = n-k ; i < n; i++) 
       {
    	   nums[j]=temp[i];
    	   j++;
       }
       for (i=0;i<n-k;i++)
       {
    	   nums[j]=temp[i];
    	   j++;
       }
//       for (int j2 = 0; j2 < temp.length; j2++) {
//			System.out.println("num = "+nums[j2]);
//       }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {-1,2,3};
		rotate1(a, 4);
	}

}

public class Solution {
    public void rotate(int[] nums, int k) {
        int temp[]=new int[nums.length];
        int n=nums.length;
        int i,j=0;
        k=k%n;
        for(i=0;i<n;i++)
        {
            temp[i]=nums[i];
        }
        for(i=n-k;i<n;i++)
        {
            nums[j]=temp[i];
            j++;
        }
        for(i=0;i<n-k;i++)
        {
            nums[j]=temp[i];
            j++;
        }
    }
}
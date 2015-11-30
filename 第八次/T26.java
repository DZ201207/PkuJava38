public class Solution {
    public int removeDuplicates(int[] nums) {
        int length=nums.length;
        while(true)
        {
          boolean b=false;
          for(int i=1;i<length;i++)
          {
            if(nums[i]==nums[i-1])
            {
                b=true;
                for(int j=i;j<length;j++)
                {
                    nums[j-1]=nums[j];
                }
                length--;
            }
          }
          if(b==false)break;
        }
        return length;
    }
}
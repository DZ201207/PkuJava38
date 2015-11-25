public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums == null)
            return 0;
        
        int len = 1;
        for(int index = 1; index < nums.length; index++){
            if(nums[index] != nums[index-1]){
                if(nums[index] != nums[len])
                    nums[len] = nums[index];
                len++;
            }
        }
        return len;
    }
}
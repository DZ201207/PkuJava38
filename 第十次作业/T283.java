public class Solution {
    public void moveZeroes(int[] nums) {
         int cnt = 0, pos = 0;
        // 将非0数字都尽可能向前排
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[pos]= nums[i];
                pos++;
            }
        }
        // 将剩余的都置0
        for(;pos<nums.length; pos++){
            nums[pos] = 0;
        }
    }
}
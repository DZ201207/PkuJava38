public class Solution {
    public void moveZeroes(int[] nums) {
         int cnt = 0, pos = 0;
        // ����0���ֶ���������ǰ��
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[pos]= nums[i];
                pos++;
            }
        }
        // ��ʣ��Ķ���0
        for(;pos<nums.length; pos++){
            nums[pos] = 0;
        }
    }
}
public class Solution {
    public int removeElement(int[] nums, int val) {
        //{1,1,2,1,2,3,2,3,1}
        int newIndex = 0;
        for (int oldIndex = 0; oldIndex < nums.length; ++oldIndex) {
            if (nums[oldIndex] != val) {
                nums[newIndex++] = nums[oldIndex];
            } 
        }
        return newIndex;
    }
}
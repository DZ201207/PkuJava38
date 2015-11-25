public class Solution {
    public boolean containsDuplicate(int[] nums) {
        //HashSet µÄÊ¹ÓÃ
        HashSet<Integer> appearedNums = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(!appearedNums.contains(nums[i])){
                appearedNums.add(nums[i]);
            } 
            else return true;
        }
        return false;
    }
}
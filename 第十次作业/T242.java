public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        
        if(String.valueOf(sArr).equals(String.valueOf(tArr)))
            return true;
        else return false;
    }
}
public class Solution 
{
    public int lengthOfLastWord(String s) 
    {
       if (s != null && !s.trim().equals("")) 
       {
			String[] arr = s.trim().split(" ");
			int length = arr[arr.length - 1].length();
			return length;
		}
		return 0;
	}
	
}
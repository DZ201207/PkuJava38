public class Solution {
    public int titleToNumber(String s) {
        String ups=s.toUpperCase();
        int result =0;
        int d = 1;
        char[] temp = ups.toCharArray();
        for(int i=temp.length-1;i>=0;i--){
        	result +=CharToNumber(temp[i])*d;
        	d*=26;
        }
        return result;
    }
    public int CharToNumber(char c){
		return (c-'A'+1);
	}
}

public class Solution {
    
    //从前往后扫描，用一个临时变量记录分段数字。
    //如果当前处理的字符对应的值和上一个字符一样，那么临时变量加上这个字符。比如III = 3
    //如果当前比前一个大，说明这一段的值应该是当前这个值减去前面记录下的临时变量中的值。比如IIV = 5 – 2
    //如果当前比前一个小，那么就可以先将临时变量的值加到结果中，然后开始下一段记录。比如VI = 5 + 1
    public int romanToInt(String s) {
        if(s.length() < 1) return 0;
        int result = 0;
        int sub = getRomanValue(s.charAt(0));
        int lastv = sub;
        for(int i = 1 ; i < s.length(); ++i) {
            char curc = s.charAt(i);
            int curv = getRomanValue(curc);
            if(curv == lastv) 
                sub += curv;
            else if( curv < lastv) {
                result += sub;
                sub = curv;
            } else {
                sub = curv - sub;
            }
            lastv = curv;
        }
        result += sub;
        return result;
    }
    public int getRomanValue(char c) {
        switch(c) {
            case 'I': return 1; 
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
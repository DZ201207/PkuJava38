public class Solution 
{
    public String intToRoman(int num) 
    {
        //1为I，2为II，3为III，4则是IV，5是V，6是VI，7是VII,8是VIII，9则是IX，10是X，11是XI，12 XII,13 XIII,14 XIV,15XV,16XVI,...
        //40为XL，41XLI，50为L，51LI，以此类推，90,100,400,500,900,1000也分别有它们的字母表示方式
        //数字的存储如下
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };  
        //对应罗马数字的存储如下，与上述数字一一对应
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };  
        //存储结果的字符串变量
        StringBuilder result = new StringBuilder();
        //values[0]（最大的，放前面）开始循环，找到符合的，减去，
        for (int i = 0; i < values.length; i++) 
        {  
            while (num >=values[i]) 
            {  
                num -= values[i];  
                result.append(numerals[i]);  
            }  
        }
        return result.toString();  
    }
}
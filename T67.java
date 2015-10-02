package excise;

public class T67 {

	public static String addBinary(String a, String b) 
	{
        int minlength = a.length()<b.length()?a.length():b.length();//找字符串短的长度
        int maxlength = a.length()>b.length()?a.length():b.length();//找字符串长的长度
        int isCarry = 0;//是否进位标记
        String result = "";
       // System.out.println("min = "+minlength);
       // System.out.println("max = "+maxlength);
        for (int i =  maxlength-1; i > maxlength-minlength-1; i--) 
        {
			int ka;//记录数组a的每个数字
			int kb;//记录数组b的每个位数字
			if (a.length()>b.length()) 
			{
				ka = a.charAt(i) - '0';
				kb = b.charAt(i-(maxlength-minlength)) - '0';
			}else {
				ka = a.charAt(i-(maxlength-minlength)) - '0';
				kb = b.charAt(i) - '0';
			}
			
			if (ka+kb+isCarry>1) //判断是否发生进位
			{
				result = (ka+kb+isCarry-2) + result;
				isCarry = 1;
			}
			else {
				result = ka+kb+isCarry+result;
				isCarry = 0;
			}
		}
        for(int i=maxlength-minlength-1;i>-1;i--)
        {
        	if (a.length()>b.length()) 
        	{
				int ka = a.charAt(i)-'0';
				if (ka+isCarry>1) {
					isCarry = 1;
					result = (ka+isCarry-2) + result;
				}
				else {
					result = ka+isCarry+result;
					isCarry = 0;
				}
			}
        	else {
        		int kb = b.charAt(i)-'0';
				if (kb+isCarry>1) {
					result = (kb+isCarry-2) + result;
					isCarry = 1;
				}
				else {
					result = kb+isCarry+result;
					isCarry = 0;
				}
			}
        }
        if (isCarry!=0) {
			result = 1+result;
		}
        
        return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		System.out.println("a+b= "+addBinary("10111", "1"));
	}

}

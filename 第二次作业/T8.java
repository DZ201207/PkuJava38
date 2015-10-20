package test;

public class T8 {

	//#8
		//将字符串转换为整数
		public static int myAtoi(String str) {
			//如果字符串为null 返回不合法
			if (null == str)
			{
				return 0;
			}
			//如果str = “”则返回不合法
			if (str.length() == 0)
			{
				return 0;
			}
			
			//str.trim()去掉首尾的空格 ，将结果存在noSPace
			String noSpace = str.trim();
			String noSigned = new String(noSpace);
			long flag = 1L;
			
			//判断字符串中是否有符号位，有则用flag记录，将去掉字符串的结果放在noSigned
			if (noSpace.charAt(0) == '-')
			{
				flag = -1L;
				noSigned = noSigned.substring(1, noSigned.length());
			}
			else if (noSpace.charAt(0) == '+')
			{
				noSigned = noSigned.substring(1, noSigned.length());
			}
			//noSigned 保存的是去掉符号的字符串。也就是正数，最终符号有flag决定
			//对noSigned从左往右遍历，直到遇到不是数字为止，记录count，count及从左往右遇到第一个不是数字时，数字的个数
			//如“123a456”,遇到a不是数字前，一共有“123”三个数字，count=3
			int count = 0;
			for (char c : noSigned.toCharArray())
			{	
				if (!Character.isDigit(c))
				{
					break;
				}
				count++;
				
			}
			//只保存前count个是数字的部分，其余舍弃
			//substring(int start,int len)的含义是，返回字符串，从start索引位开始，往后取count位之间的字符串。
			//如str = "12345",则str.substring(0,3)返回的是“123”
			noSigned = noSigned.substring(0, count);
			
			
			final long MAX_INT = 2147483647;
			final long MIN_INT = -2147483648;
			long result = 0L;
			
			for (int i = 0; i < noSigned.length(); i++)
			{
				//如果result的值大于最大正数，则让循环结束，让result等于比最大正数大一点的数
				if (result > MAX_INT + 3)
				{
					result = MAX_INT + 3;
					break;
				}
				//将字符串的正数逐位取出来，并计算
				int num = noSigned.charAt(i) - 0x30;
				result = result * 10 + num;
				
			}
			//取符号位
			result = result * flag;
			if (result > MAX_INT)
			{
				result = MAX_INT;

			}
			else if (result < MIN_INT)
			{
				result = MIN_INT;
			}

			return (int) result;
			
		}
}

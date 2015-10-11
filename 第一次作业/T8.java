package excise;

public class T8 {

	 public static int myAtoi(String str) 
	 {
		 if(str==null||str.length() ==0 ) return 0;
		 String strs[] = str.trim().split(" ");
		 int result = 0;
		 int length = 0;
		// System.out.println("str = "+str);
		 //System.out.println("strs[0] = "+strs[0].length());
		 if (strs[0].length()>1 && (strs[0].charAt(1)=='+' ||  strs[0].charAt(1)=='-')) 
				return 0;
		 
		 int k = strs[0].charAt(0)-'0';
		 if (k>=0 && k<=9)
		 {
				result = result*10+k;
				length++;
		 }
		 
		for (int j = 1; j <=strs[0].length()-1; j++) 
		{
			int m = strs[0].charAt(j)-'0';
			if (!(m>=0 && m<=9)) 
				break;
			result = result*10+m;
			length++;
				//System.out.println("result = "+result);
		}
		 
//		 for (int i = 1; i < strs.length; i++) 
//		 {
//			for (int j = 0; j <= strs[i].length()-1 ; j++) 
//			{
//				if (!(strs[i].charAt(1)<='9'&& strs[i].charAt(1)>='0')) 
//				{
//					if (strs[0].charAt(0)=='-') 
//						result= -result;
//					return result;
//				}
//				else {
//					result = result*10+(strs[i].charAt(j)-'0');
//				}
//			}
//		}
//		//System.out.println("result = "+result);
		if (strs[0].charAt(0)=='-') 
			result= -result;
		else if (strs[0].charAt(0)!='+'&& !(k>=0 && k<=9))
		{
			return 0;
		}
		if ((strs[0].charAt(0)=='+'  || (k>=0 && k<=9)) && (result<0 || length>10)) {
			result = 2147483647;
		}
		else if (strs[0].charAt(0)=='-' && (result>0 || length>10)) {
			result = -2147483648;
		}
		
		return result;
	 }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("T8 test = "+myAtoi("      -1191"));

	}

}

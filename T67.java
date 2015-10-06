package test;

public class T67 {

	public static String addBinary(String a, String b) {
        
		//判断输入的参数是否有效
		if ( isInValidBinary(a) || isInValidBinary(b))
		{
			return null;
		}
		//将string转成bytes
		byte isPromot = 0;
		byte[] aBytes = a.getBytes();
		byte[] bBytes = b.getBytes();
		String result = "";
		int i = aBytes.length - 1, j = bBytes.length - 1;
		for (; i >= 0 && j >=0; i--, j--)
		{
			byte value = (byte) ((aBytes[i] + bBytes[j] + isPromot) & 0x01);
			//System.out.println("i="+i+"  j="+j+"  value="+value);
			isPromot = (byte) (((aBytes[i] + bBytes[j] +isPromot) & 0x02) >> 1); 
			//System.out.println("i="+i+"  j="+j+"  isPromot="+isPromot);
			result += value;
			//System.out.println("i="+i+"  j="+j+"  result="+result);
		}
		
		if (i < 0)
		{
			
			for (; j >= 0; j--)
			{
				byte value = (byte) ((bBytes[j] + isPromot) & 0x01);
				isPromot = (byte) (((bBytes[j] +isPromot) & 0x02) >> 1); 
				result += value;
			}
		}
		else
		{
			for (; i >= 0; i--)
			{
				byte value = (byte) ((aBytes[i] + isPromot) & 0x01);
				isPromot = (byte) (((aBytes[i] +isPromot) & 0x02) >> 1); 
				result += value;
			}
		}
		result += isPromot;
		
		//System.out.println("this result "+result+ " length is "+result.length());
		
		//将结果最高位的0去掉
		int k = result.length() - 1;
		for (; k > 0; k--)
		{
			if  (result.charAt(k) == '1')
			{
				break;
			}
		}
		//System.out.println("k is "+ k);
		result = result.substring(0, k + 1);
		//System.out.println("this result "+result);
		//将结果反转
		StringBuffer stringBuffer = new StringBuffer(result);
		
		return stringBuffer.reverse().toString();
	}
	
	public static boolean isInValidBinary(String src)
	{
		for (char c : src.toCharArray())
		{
			if ((c != '0') && (c != '1'))
			{
				return true;
				
			}
			
		}
		return false;
	}
}

package test;

public class T58 {

	//#58
		//����ĳ�ַ������һ�����ʵĳ���
		public static int lengthOfLastWord(String s) {
	        if (null == s)
	        {
	        	return 0;
	        }
	        if ("".equals(s))
	        {
	        	return 0;
	        }
	        //���ݿո�һ�����߶���ո񣩷ִ�
	        String[] strArray = s.trim().split("\\s{1,}");
			String result= strArray[strArray.length-1];
			//System.out.println(result);
			return result.length();
	    }
}

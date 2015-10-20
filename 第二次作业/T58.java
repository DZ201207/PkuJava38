package test;

public class T58 {

	//#58
		//计算某字符串最后一个单词的长度
		public static int lengthOfLastWord(String s) {
	        if (null == s)
	        {
	        	return 0;
	        }
	        if ("".equals(s))
	        {
	        	return 0;
	        }
	        //根据空格（一个或者多个空格）分词
	        String[] strArray = s.trim().split("\\s{1,}");
			String result= strArray[strArray.length-1];
			//System.out.println(result);
			return result.length();
	    }
}

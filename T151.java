package excise;

import java.util.ArrayList;

public class T151 {
	
	 public static String reverseWords(String s) {
			 if (s==null)
					return null;
			 s = s.trim();
	        if (s.length()==0) {
				return "";
			}
	        String strs[] = s.split("\\s+"); 

	        String result = strs[0];
	        for (int i = 1; i < strs.length; i++) {
				result =  strs[i]+" "+ result;
			}
	        
	        return result;
	  }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(reverse("12345", 0, 3));
		System.out.println("@"+reverseWords("1  2 3 4     5"));
//		String string = "1  2 3 4     5";
//		String[] strings = string.split("\\s+");
//		System.out.println("str ="+strings.length);
//		for (int i = 0; i < strings.length; i++) {
//			System.out.println("T151.main():"+strings[i]);
//		}
//		StringBuffer stringBuffer = new StringBuffer(string);
//		System.out.println(stringBuffer.reverse());
	}

}

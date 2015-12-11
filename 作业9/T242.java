package excise;

import java.util.Arrays;

public class T242 {
	public static boolean isAnagram(String s, String t) {
		if(s.length()!=t.length()) return false;
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        Arrays.sort(cht);
        Arrays.sort(chs);
        for (int i = 0; i < cht.length; i++) {
			if(chs[i]!=cht[i]) return false;
		}
        return true;
    }
	public static void main(String[] args) {
		String s1="anagram";
		String s2="nagaram";
		System.out.println(isAnagram(s1, s2));
	}

}

package excise;

public class T58 {
	public static int lengthOfLastWord(String s) {
		String strs[] = s.split(" ");
		if (strs.length==0) {
			return 0;
		}
		return strs[strs.length-1].length();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("length = "+lengthOfLastWord(" "));
	}

}

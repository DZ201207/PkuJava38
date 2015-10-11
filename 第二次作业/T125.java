package excise;

public class T125 {
	public static boolean isPalindrome(String s) {
		char chs[] = s.toCharArray();
        int first = 0;
        int tail = s.length()-1;
        boolean isPanama = true;
        
        do {
        	while(first<chs.length && !(Character.isLetter(chs[first])|| Character.isDigit(chs[first]))) first++;
        	while(tail>-1 && !(Character.isLetter(chs[tail])|| Character.isDigit(chs[tail]))) tail--;
        	if (first>=tail) break;
        	if (Character.toLowerCase(chs[first]) != Character.toLowerCase(chs[tail])) {
        		isPanama = false;
        		break;
        	}
        	first++;
        	tail--;
        	
		}while (true);
        
		return isPanama;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(" "));
		//System.out.println("T125.main()"+Character.isLetter('p'));
	}

}

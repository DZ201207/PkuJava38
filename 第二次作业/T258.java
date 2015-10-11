package excise;

public class T258 {
	 public static int addDigits(int num) {
	       while(num>9){
	    	   char chs[] = (num+"").toCharArray();
	    	   num = 0;
	    	   for (int i = 0; i < chs.length; i++) {
	    		   num += (chs[i]-'0');
	    	   }
	       }
	       return num;
	 }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addDigits(38));

	}

}

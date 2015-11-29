package excise;

public class T231 {
	 public static boolean isPowerOfTwo(int n) {
		 if(n<=0) return false;
	      while(n!=1){
	    	  if (n%2==1) return false;
	    	  else {
				n=n/2;
			}
	      }  
	      return true;
	 }
	 public static boolean isPowerOfTwo2(int n) {  
	       return n > 0 && ((n & (n - 1)) == 0 );  
	    }  
	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(10));
	}

}

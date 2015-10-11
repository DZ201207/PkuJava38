package excise;

public class T7 {
	public static int reverse(int x) {
		int isPositive = 1;
		if (x<0) {
			isPositive = -1;
			x = -x;
		}
		
		char []num= (x+"").toCharArray();
		long n=0;
		for (int i = num.length-1; i >-1 ; i--) {
			
			n*=10;
			n+=(num[i]-'0');
			if (n>Integer.MAX_VALUE) {
				return 0;
			}
		}
        return ((int)n)*isPositive;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(reverse(1534236469));
		//System.out.println("T7.main()"+Integer.MAX_VALUE);

	}

}

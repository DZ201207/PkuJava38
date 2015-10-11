package excise;

public class T263 {
	public static boolean isUgly(int num) {
		if (num==0) return false;
        for (; num%5==0; num/=5);
        for (; num%3==0; num/=3);
        for (; num%2==0; num/=2);
		return (num==1);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isUgly(14));
	}

}

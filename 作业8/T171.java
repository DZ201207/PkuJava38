package excise;

public class T171 {
	public static int titleToNumber(String s) {
        int sum=0;
        int len=s.length();
        for(int i=0;i<len;i++)
        {
            int a=s.charAt(i)-64;
            int b=len-1-i;
            sum=sum+a*(int)(Math.pow(26,b));
        }
        return sum;
    }
	public static void main(String[] args) {
		System.out.println(titleToNumber("AB"));

	}

}

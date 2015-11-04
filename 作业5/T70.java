package excise;

public class T70 {
	 public static int climbStairs(int n) {
		 if (n==0) return 0;
		 if (n==1) return 1;
		 if (n==2) return 2;
		 
		 int steps[] = new int[n+1];
		 steps[1] = 1;
		 steps[2] = 2;
		 for (int i = 3; i < n+1; i++) {
			steps[i] = steps[i-1]+steps[i-2];
		}
		 return steps[n];
	 }
	       
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(climbStairs(10));

	}

}

package excise;

public class T172 {
	public static int trailingZeroes(int n) {
		if (n < 1)
			return 0;
		int c = 0;

		while (n / 5 != 0) {
			n /= 5;
			c += n;
		}

		return c;
	}

	public static void main(String[] args) {
		System.out.println(trailingZeroes(5));

	}

}

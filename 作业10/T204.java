package excise;

public class T204 {
	public static int countPrimes(int n) {
		if (n <= 1)
			return 0;
		boolean flag[] = new boolean[n];// false默认是素数
		for (int i = 2; i * i < n; i++) {
			if (!flag[i]) {
				for (int j = i; i * j < n; j++) {
					// System.out.println("T " + i * j);
					flag[i * j] = true;
				}
			}
		}
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (!flag[i])
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(countPrimes(499979));
	}

}

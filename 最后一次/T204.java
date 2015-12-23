public class Solution {
    public int countPrimes(int n) {
        if (n <= 1)
			return 0;
		boolean flag[] = new boolean[n];// falseÄ¬ÈÏÊÇËØÊý
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
}
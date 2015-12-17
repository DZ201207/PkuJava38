package excise;

public class T88 {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		/*
		 * for (int i = 0; i < n; i++) { nums1[m + i] = nums2[i]; }
		 * Arrays.sort(nums1, 0, n + m);
		 */
		int tail = m + n - 1;
		int length = m + n;
		for (int i = 0; i < length; i++) {
			if (n < 1)
				break;
			if (m < 1) {
				nums1[tail] = nums2[n - 1];
				n--;
				tail--;
				continue;
			}
			if (nums1[m - 1] > nums2[n - 1]) {
				nums1[tail] = nums1[m - 1];
				m--;
			} else {
				nums1[tail] = nums2[n - 1];
				n--;
			}
			tail--;
		}
	}

	public static void main(String[] args) {
		int a[] = { 2, 0 };
		int b[] = { 1 };
		merge(a, 1, b, 1);
		for (int i = 0; i < 2; i++) {
			System.out.println(a[i]);
		}
	}

}

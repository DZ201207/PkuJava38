public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
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
}
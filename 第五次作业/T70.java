public class Solution {
    public int climbStairs(int n) {
        // if (n == 0 || n == 1) return 1;
        // if (n < 0) return 0;
        // return climbStairs(n - 1) + climbStairs(n - 2);  
        //ʹ�õݹ鷽���ᳬʱ�����ʹ�ö�̬�滮��DP�����ֲ����
        if (n == 0 || n == 1) return 1;
        int prev = 1;//��ֵ
        int current = 1;//��ֵ
        for (int i = 2; i <= n; i++) {
            int temp = current + prev;//��ǰֵ��ǰһ��ֵ
            prev = current;
            current = temp;
        }
        return current;
    }
}
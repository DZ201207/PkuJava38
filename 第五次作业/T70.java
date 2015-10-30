public class Solution {
    public int climbStairs(int n) {
        // if (n == 0 || n == 1) return 1;
        // if (n < 0) return 0;
        // return climbStairs(n - 1) + climbStairs(n - 2);  
        //使用递归方法会超时，因此使用动态规划（DP），分步解决
        if (n == 0 || n == 1) return 1;
        int prev = 1;//初值
        int current = 1;//初值
        for (int i = 2; i <= n; i++) {
            int temp = current + prev;//当前值加前一个值
            prev = current;
            current = temp;
        }
        return current;
    }
}
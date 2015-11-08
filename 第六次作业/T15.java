public class Solution {
    
    //暴力解决法是每个人都能想到的，三层for循环
    //我们不妨先对数组排个序。
    //排序之后，我们就可以对数组用两个指针分别从前后两端向中间扫描了，如果是 2Sum，我们找到两个指针之和为target就OK了，那 3Sum 类似，我们可以先固定一个数，然后找另外两个数之和为第一个数的相反数就可以了。
    List<List<Integer>> ret = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> threeSum(int[] num) {
        if (num == null || num.length < 3) return ret;
        
        Arrays.sort(num);
        
        int len = num.length;
        for (int i = 0; i < len-2; i++) {
            if (i > 0 && num[i] == num[i-1]) continue;
            find(num, i+1, len-1, num[i]); //寻找两个数与num[i]的和为0
        }
        
        return ret;
    }
    
    public void find(int[] num, int begin, int end, int target) {
        int l = begin, r = end;
        while (l < r) {
            if (num[l] + num[r] + target == 0) {
                List<Integer> ans = new ArrayList<Integer>();
                ans.add(target);
                ans.add(num[l]);
                ans.add(num[r]);
                ret.add(ans); //放入结果集中
                while (l < r && num[l] == num[l+1]) l++;
                while (l < r && num[r] == num[r-1]) r--;
                l++;
                r--;
            } else if (num[l] + num[r] + target < 0) {
                l++;
            } else {
                r--;
            }
        }
    }
}
public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        
        //总体思路：求出每两个数的和，放到 HashSet 里，再利用之前的 2Sum 去求。这种算法比较快，复杂度 O(nnlog(n))
        
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        HashMap<Integer, List<Integer[]>> hm = new HashMap<Integer, List<Integer[]>>();
        int len = num.length;
        //数组排序
        Arrays.sort(num);
        // 计算、存储两个数的和
        //num[0]+num[1],num[0]+num[2], ... ,num[len-1]+num[len]
        for (int i = 0; i < len - 1; ++i) {
            for (int j = i + 1; j < len; ++j) {
                int sum = num[i] + num[j];
                Integer[] tuple = {num[i], i, num[j], j};
                //没有该sum数字（key）存在，则直接建立并添加映射组合进去
                if (!hm.containsKey(sum)) {
                    hm.put(sum, new ArrayList<Integer[]>());
                }
                //已经有该sum则建立新的映射
                hm.get(sum).add(tuple);
            }
        }
        
        //获取全部的key记录在Integer[] keys中
        Integer[] keys = hm.keySet().toArray(new Integer[hm.size()]);
        //声明一个int变量key  
        //并且该变量key是keys集合的元素的代表
        //当keys里面没有元素的时候，循环也就结束了。
        //key也就相当于是一个循环变量
        for (int key : keys) {
            if (hm.containsKey(key)) {
                if (hm.containsKey(target - key)) {
                    //存在某两个key，使得相加等于target，存储两个Pairs
                    List<Integer[]> first_pairs = hm.get(key);
                    List<Integer[]> second_pairs = hm.get(target - key);
                    
                    //因为同一个Key可能存在好几个映射，所以做for循环,分次数处理
                    for (int i = 0; i < first_pairs.size(); ++i) {
                        Integer[] first = first_pairs.get(i);
                        for (int j = 0; j < second_pairs.size(); ++j) {
                            Integer[] second = second_pairs.get(j);
                            // check 查重啦，这个很重要，毕竟是取得和么，万一四个数里面有一个数占了两次就不行了！所以要查重
                            //保证第一个的i和第二个的i不相等，第一个的i和第二个的j不相等，第一个的j和第二个的i不相等，第一个的j和第二个的j不相等，所以前面要存i,j
                            if (first[1] != second[1] && first[1] != second[3] &&
                                    first[3] != second[1] && first[3] != second[3]) {
                                //都不重复，就可以直接取值啦，取出的四个值就是返回的ret的啦
                                List<Integer> ans = Arrays.asList(first[0], first[2], second[0], second[2]);
                                //对数据集合，即List进行排序  区别于 Arrays.sort(数组名)哟
                                Collections.sort(ans);
                                //如果不包含这个组合才可以的了啦~最后还要差重复= =也是累...
                                if (!ret.contains(ans)) {
                                    ret.add(ans);
                                }
                            }
                        }
                    }
                    //移除这两个Key，以后就不会再检索到啦
                    hm.remove(key);
                    hm.remove(target - key);
                }
            }
        }

        return ret;
    }
}

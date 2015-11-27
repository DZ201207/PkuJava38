public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        
        //����˼·�����ÿ�������ĺͣ��ŵ� HashSet �������֮ǰ�� 2Sum ȥ�������㷨�ȽϿ죬���Ӷ� O(nnlog(n))
        
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        HashMap<Integer, List<Integer[]>> hm = new HashMap<Integer, List<Integer[]>>();
        int len = num.length;
        //��������
        Arrays.sort(num);
        // ���㡢�洢�������ĺ�
        //num[0]+num[1],num[0]+num[2], ... ,num[len-1]+num[len]
        for (int i = 0; i < len - 1; ++i) {
            for (int j = i + 1; j < len; ++j) {
                int sum = num[i] + num[j];
                Integer[] tuple = {num[i], i, num[j], j};
                //û�и�sum���֣�key�����ڣ���ֱ�ӽ��������ӳ����Ͻ�ȥ
                if (!hm.containsKey(sum)) {
                    hm.put(sum, new ArrayList<Integer[]>());
                }
                //�Ѿ��и�sum�����µ�ӳ��
                hm.get(sum).add(tuple);
            }
        }
        
        //��ȡȫ����key��¼��Integer[] keys��
        Integer[] keys = hm.keySet().toArray(new Integer[hm.size()]);
        //����һ��int����key  
        //���Ҹñ���key��keys���ϵ�Ԫ�صĴ���
        //��keys����û��Ԫ�ص�ʱ��ѭ��Ҳ�ͽ����ˡ�
        //keyҲ���൱����һ��ѭ������
        for (int key : keys) {
            if (hm.containsKey(key)) {
                if (hm.containsKey(target - key)) {
                    //����ĳ����key��ʹ����ӵ���target���洢����Pairs
                    List<Integer[]> first_pairs = hm.get(key);
                    List<Integer[]> second_pairs = hm.get(target - key);
                    
                    //��Ϊͬһ��Key���ܴ��ںü���ӳ�䣬������forѭ��,�ִ�������
                    for (int i = 0; i < first_pairs.size(); ++i) {
                        Integer[] first = first_pairs.get(i);
                        for (int j = 0; j < second_pairs.size(); ++j) {
                            Integer[] second = second_pairs.get(j);
                            // check ���������������Ҫ���Ͼ���ȡ�ú�ô����һ�ĸ���������һ����ռ�����ξͲ����ˣ�����Ҫ����
                            //��֤��һ����i�͵ڶ�����i����ȣ���һ����i�͵ڶ�����j����ȣ���һ����j�͵ڶ�����i����ȣ���һ����j�͵ڶ�����j����ȣ�����ǰ��Ҫ��i,j
                            if (first[1] != second[1] && first[1] != second[3] &&
                                    first[3] != second[1] && first[3] != second[3]) {
                                //�����ظ����Ϳ���ֱ��ȡֵ����ȡ�����ĸ�ֵ���Ƿ��ص�ret����
                                List<Integer> ans = Arrays.asList(first[0], first[2], second[0], second[2]);
                                //�����ݼ��ϣ���List��������  ������ Arrays.sort(������)Ӵ
                                Collections.sort(ans);
                                //��������������ϲſ��Ե�����~���Ҫ���ظ�= =Ҳ����...
                                if (!ret.contains(ans)) {
                                    ret.add(ans);
                                }
                            }
                        }
                    }
                    //�Ƴ�������Key���Ժ�Ͳ����ټ�������
                    hm.remove(key);
                    hm.remove(target - key);
                }
            }
        }

        return ret;
    }
}

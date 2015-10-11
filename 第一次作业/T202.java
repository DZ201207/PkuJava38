package excise;

import java.util.HashMap;

public class T202 {
	public static boolean isHappy(int n) 
	{
        int sum = 0;//
        int k=0;//用来表示n的每一位数字
        HashMap<Integer , Integer> hashMap = new HashMap<Integer, Integer>();//用来保存每次生成的数据判断是否进入循环
        
        while (n != 1) 
        {
        	sum = 0;
        	while (n!=0) 
            {
    			k = n%10;
    			sum = sum + k*k;
    			n = n/10;
    			//System.out.print("k = "+k+" ");
    		}
        	n = sum;
        	if (hashMap.get(sum)!=null) {
				return false;//说明进入了死循环了
			}
        	hashMap.put(sum, 1);
        	
        	//System.out.println("sum = "+sum);
		}
        return true;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("T202 isHappy: "+isHappy(2));
	}

}

public class Solution {
    public boolean isHappy(int n) {
        int sum=0,k=0;
        HashMap<Integer,Integer>hashMap=new HashMap<Integer,Integer>();
        while(n!=1)
        {
            sum=0;
            while(n!=0)
            {
                k=n%10;
                sum=sum+k*k;
                n=n/10;
            }
            n=sum;
            if(hashMap.get(sum)!=null)
            return false;
            hashMap.put(sum,1);
        }
        return true;
    }
}
public class Solution {
    public int reverse(int x) {
        if (x==Integer.MIN_VALUE) return 0;
        int flag=1;
        if(x<0)
        {
            flag=-1;
            x=-x;
        }
        long y=x%10;
        while(x/10!=0)
        {
            x=x/10;
            y=y*10+x%10;
           
        }
        if(y>Integer.MAX_VALUE) return 0;
        else return (int)(flag*y);
    }
}
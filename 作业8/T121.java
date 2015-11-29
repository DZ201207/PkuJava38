package excise;

public class T121 {
	public static int maxProfit(int[] prices) {
        if (prices.length==0) return 0;
        int min=prices[0];
        int maxPro = 0;
        for (int i = 0; i < prices.length; i++) {
			min=prices[i]<min?prices[i]:min;
			maxPro=(prices[i]-min)>maxPro?(prices[i]-min):maxPro;
		}
		return maxPro;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub.
		int a[]={3,8,2,4,6};
		System.out.println(maxProfit(a));
	}

}

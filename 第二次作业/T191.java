package test;

public class T191 {
	//计算一个整数中有多少个1  等价于  计算一个整数内存中1的个数
		public static int hammingWeight(int n) {
	     
			//java 中int 占4个字节
			int oneCount = 0;
			for (int i = 0; i < 32; i++, n>>=1)
			{
				int bit = n & 0x0001;
				if (1 == bit)
				{
					oneCount ++;
				}
			}
			return oneCount;
	    }

}

package test;

public class T191 {
	//����һ���������ж��ٸ�1  �ȼ���  ����һ�������ڴ���1�ĸ���
		public static int hammingWeight(int n) {
	     
			//java ��int ռ4���ֽ�
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

package excise;

public class T191 {
	  public static int hammingWeight(int n) 
	  {
	        int number = 0;//记录“1”的个数
	        int target = n;//充当基数
	        if (n<2) {
				return n;
			}
	        while (target>0) 
	        {
	        	//System.out.println("target = "+target);
				if (target%2==1) {
					number++;
					target = target/2;
					//System.out.println("target = "+target);
				}
				else {
					target/=2;
				}
			}
	        return number;
	  }
	  public static int hammingWeight1(int n) 
	  {
	       int number = 0;//记录“1”的个数
	        long target = n;//充当基数
	        //System.out.println("target = "+target);
	        for (int i = 0; i < 32; i++) 
	        {
				if((target&1)==1)
					number++;
				target = target>>1;
			}
	        
	        return number;
	  }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("num = "+hammingWeight1(11));;
	}

}

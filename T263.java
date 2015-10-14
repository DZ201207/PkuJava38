public class Solution {
    public boolean isUgly(int num) {
		if (num <= 0)
		{
			return false;
		}
        int currentNum = num;
        for (; currentNum > 1; currentNum /= 5)
		{
			int res = currentNum % 5;
			if (0 != res)
			{
				break;
			}
		}
        for (; currentNum > 1; currentNum /= 3)
		{
			int res = currentNum % 3;
			if (0 != res)
			{
				break;
			}
		}
		for (; currentNum > 1; currentNum >>= 1)
		{
			int res = currentNum % 2;
			if (0 != res)
			{
				break;
			}
		}
		
		if (1 == currentNum)
		{
			return true;
		}
		else 
		{
			return false;
		}
		//return true;
    }
}
public class Solution {
    public boolean isPowerOfTwo(int n) {
        //�����power of two, ��2���Ʊ����,���ҽ���һ��1.  ����ͨ����λ����1�ĸ���, ��������һ������İ취, ���ж�   N & (N-1) �Ƿ�Ϊ0
        if(n > 0 && ((n & (n - 1)) == 0 ))
            return true;
        return false;    }
}
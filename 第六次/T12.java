public class Solution 
{
    public String intToRoman(int num) 
    {
        //1ΪI��2ΪII��3ΪIII��4����IV��5��V��6��VI��7��VII,8��VIII��9����IX��10��X��11��XI��12 XII,13 XIII,14 XIV,15XV,16XVI,...
        //40ΪXL��41XLI��50ΪL��51LI���Դ����ƣ�90,100,400,500,900,1000Ҳ�ֱ������ǵ���ĸ��ʾ��ʽ
        //���ֵĴ洢����
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };  
        //��Ӧ�������ֵĴ洢���£�����������һһ��Ӧ
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };  
        //�洢������ַ�������
        StringBuilder result = new StringBuilder();
        //values[0]�����ģ���ǰ�棩��ʼѭ�����ҵ����ϵģ���ȥ��
        for (int i = 0; i < values.length; i++) 
        {  
            while (num >=values[i]) 
            {  
                num -= values[i];  
                result.append(numerals[i]);  
            }  
        }
        return result.toString();  
    }
}
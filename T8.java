package test;

public class T8 {

	//#8
		//���ַ���ת��Ϊ����
		public static int myAtoi(String str) {
			//����ַ���Ϊnull ���ز��Ϸ�
			if (null == str)
			{
				return 0;
			}
			//���str = �����򷵻ز��Ϸ�
			if (str.length() == 0)
			{
				return 0;
			}
			
			//str.trim()ȥ����β�Ŀո� �����������noSPace
			String noSpace = str.trim();
			String noSigned = new String(noSpace);
			long flag = 1L;
			
			//�ж��ַ������Ƿ��з���λ��������flag��¼����ȥ���ַ����Ľ������noSigned
			if (noSpace.charAt(0) == '-')
			{
				flag = -1L;
				noSigned = noSigned.substring(1, noSigned.length());
			}
			else if (noSpace.charAt(0) == '+')
			{
				noSigned = noSigned.substring(1, noSigned.length());
			}
			//noSigned �������ȥ�����ŵ��ַ�����Ҳ�������������շ�����flag����
			//��noSigned�������ұ�����ֱ��������������Ϊֹ����¼count��count����������������һ����������ʱ�����ֵĸ���
			//�硰123a456��,����a��������ǰ��һ���С�123���������֣�count=3
			int count = 0;
			for (char c : noSigned.toCharArray())
			{	
				if (!Character.isDigit(c))
				{
					break;
				}
				count++;
				
			}
			//ֻ����ǰcount�������ֵĲ��֣���������
			//substring(int start,int len)�ĺ����ǣ������ַ�������start����λ��ʼ������ȡcountλ֮����ַ�����
			//��str = "12345",��str.substring(0,3)���ص��ǡ�123��
			noSigned = noSigned.substring(0, count);
			
			
			final long MAX_INT = 2147483647;
			final long MIN_INT = -2147483648;
			long result = 0L;
			
			for (int i = 0; i < noSigned.length(); i++)
			{
				//���result��ֵ�����������������ѭ����������result���ڱ����������һ�����
				if (result > MAX_INT + 3)
				{
					result = MAX_INT + 3;
					break;
				}
				//���ַ�����������λȡ������������
				int num = noSigned.charAt(i) - 0x30;
				result = result * 10 + num;
				
			}
			//ȡ����λ
			result = result * flag;
			if (result > MAX_INT)
			{
				result = MAX_INT;

			}
			else if (result < MIN_INT)
			{
				result = MIN_INT;
			}

			return (int) result;
			
		}
}

package yxguo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class WordsWork {

	public static void main(String[] args) throws Exception {
		String lineSeparator = System.getProperty("line.separator"); // ��ȡ��ǰ����ϵͳ�Ļ��з�
		// a��b�ڹ���binĿ¼��
		FileManager atext = new FileManager("a.txt", new String[] { "\n", "\r\n" });
		FileManager btext = new FileManager("b.txt", new String[] { "\n", "\r\n", "\\s" }); // \\s��ʾ�ո�

		String aw = null;
		String bw = null;
		Set set = new HashSet();
		Set aset = new HashSet();
		Set bset = new HashSet();
		HashMap map = new HashMap();
		List l1 = new ArrayList<>();
		List l2 = new ArrayList<>();

		/** ��a��b �е��� ����HashSet **/
		while ((aw = atext.nextWord()) != null) {
			set.add(aw);
			aset.add(aw);
			l1.add(aw);

		}
		while ((bw = btext.nextWord()) != null) {
			set.add(bw);
			bset.add(bw);
			l2.add(bw);
		}

		/** �ر��ļ���Դ���� **/
		atext.close();
		btext.close();

		// System.out.println(set.size());
		Iterator n = set.iterator();
		System.out.println("���в��ظ��ĵ���:");
		while (n.hasNext()) {// ���� ȥ��
			System.out.println(n.next());
		}
		System.out.println("a��" +l1);
		System.out.println("b��" +l2);
		
		System.out.println("����Ϊ" + getIntersection(l1, l2)+"\n");
		System.out.println("a�е�����Ϊ" + aset.size());
		System.out.println("b�е�����Ϊ" + bset.size());
		
	}
	public static List<String> getIntersection(List<String> list1,
			List<String> list2) {
		List<String> result = new ArrayList<String>();
		for (String tmp : list2) {//����list1
			if (list1.contains(tmp)) {//�������
				result.add(tmp);//�Ž�һ��list���棬���list���ǽ���
			}
		}
		return result;
	}

	
}

class FileManager {
	String[] words = null;
	int pos = 0;
	FileInputStream f = null;

	public FileManager() {
	}

	public FileManager(String fileName, String[] seperators) throws Exception {
		/** ��ȡ��ǰ��Ŀ����·�� */
		URL classpath = FileManager.class.getClassLoader().getResource("");

		File file = new File(classpath.getFile(), fileName);
		f = new FileInputStream(file);

		/** ���ļ��ж�ȡ���� **/
		byte[] a = new byte[f.available()];
		int len = f.read(a);
		int total = 0;
		// ���totalС���ֽ�����ĳ��ȣ�˵���ļ�û�ж�ȡ���
		while (total < a.length) {
			total += len;
			// ���ֽ�������д�����ݣ���ʼƫ�������Ѷ�ȡ���ݳ��ȣ� a.length - total��ʾʣ�����ݳ���
			len = f.read(a, total, a.length - total);
		}
		StringBuffer buffer = new StringBuffer();
		for (String seperator : seperators) {
			buffer.append(seperator + "|");
		}
		buffer.deleteCharAt(buffer.length() - 1);
		words = new String(a).split(buffer.toString());
	}

	public String nextWord() {
		if (pos >= words.length) {
			return null;
		}
		return words[pos++];
	}

	public void close() {
		if (f != null) {
			try {
				f.close();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				f = null;
			}
		}
	}
}
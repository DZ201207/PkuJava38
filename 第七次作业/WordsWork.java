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
		String lineSeparator = System.getProperty("line.separator"); // 获取当前操作系统的换行符
		// a，b在工程bin目录下
		FileManager atext = new FileManager("a.txt", new String[] { "\n", "\r\n" });
		FileManager btext = new FileManager("b.txt", new String[] { "\n", "\r\n", "\\s" }); // \\s表示空格

		String aw = null;
		String bw = null;
		Set set = new HashSet();
		Set aset = new HashSet();
		Set bset = new HashSet();
		HashMap map = new HashMap();
		List l1 = new ArrayList<>();
		List l2 = new ArrayList<>();

		/** 把a，b 中单词 放入HashSet **/
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

		/** 关闭文件资源连接 **/
		atext.close();
		btext.close();

		// System.out.println(set.size());
		Iterator n = set.iterator();
		System.out.println("所有不重复的单词:");
		while (n.hasNext()) {// 遍历 去重
			System.out.println(n.next());
		}
		System.out.println("a：" +l1);
		System.out.println("b：" +l2);
		
		System.out.println("交集为" + getIntersection(l1, l2)+"\n");
		System.out.println("a中单词数为" + aset.size());
		System.out.println("b中单词数为" + bset.size());
		
	}
	public static List<String> getIntersection(List<String> list1,
			List<String> list2) {
		List<String> result = new ArrayList<String>();
		for (String tmp : list2) {//遍历list1
			if (list1.contains(tmp)) {//如果存在
				result.add(tmp);//放进一个list里面，这个list就是交集
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
		/** 获取当前项目的类路径 */
		URL classpath = FileManager.class.getClassLoader().getResource("");

		File file = new File(classpath.getFile(), fileName);
		f = new FileInputStream(file);

		/** 从文件中读取数据 **/
		byte[] a = new byte[f.available()];
		int len = f.read(a);
		int total = 0;
		// 如果total小于字节数组的长度，说明文件没有读取完成
		while (total < a.length) {
			total += len;
			// 向字节数组中写入数据，起始偏移量是已读取数据长度， a.length - total表示剩余数据长度
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
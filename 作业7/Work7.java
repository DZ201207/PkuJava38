import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;


public class Work7 {
	/**
	 * 两个文件总共的词汇表（即所有不重复的单词）
	 * **/
	private List<String> two_file_statistics;
	/**
	 *两个文件中的交集单词词汇表
	 * **/
	private List<String> two_file_duplicate;
	/**
	 *表 1 包含的单词总数
	 * **/
	private int file1_count;
	/**
	 *表 2 包含的单词总数
	 * **/
	private int file2_count;
	
	public Work7(){}
	
	public void wordsList(String file1,String file2)  {
		InputStreamReader isr1 = null;
		InputStreamReader isr2 = null;
			try {
				isr1 = new InputStreamReader(new FileInputStream(file1),"GBK");
				isr2 = new InputStreamReader(new FileInputStream(file2),"GBK");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			
		
		BufferedReader in1=new BufferedReader(isr1);
		BufferedReader in2=new BufferedReader(isr2);
		//哈希set来统计两个文件总共的词汇表（即所有不重复的单词）
		HashSet<String> two_file_words = new LinkedHashSet<>();
		//哈希set来统计文件1的词汇表
		HashSet<String> fileHashSet1 = new LinkedHashSet<>();
		//哈希set来统计文件2的词汇表
		HashSet<String> fileHashSet2 = new LinkedHashSet<>();
		
		String line=null;
		try {
			//读第一个文件
			while ((line=in1.readLine())!=null) {
				line = line.replaceAll("[\\pP+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]", " ");
				System.out.println(line);
				String strs[]= line.split("\\s+");
				for (int i = 0; i < strs.length; i++) {
					two_file_words.add(strs[i]);
					fileHashSet1.add(strs[i]);
				}
				
			}
			//读第二个文件
			while ((line=in2.readLine())!=null) {
				line = line.replaceAll("[\\pP+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]", " ");
				String strs[]= line.split("\\s+");
				for (int i = 0; i < strs.length; i++) {
					two_file_words.add(strs[i]);
					fileHashSet2.add(strs[i]);
				}
				
			}
			in1.close();
			in2.close();
			two_file_statistics=new LinkedList<String>(two_file_words);
			//获取两个文件重复的单词
			Iterator iterator = fileHashSet1.iterator();
			two_file_duplicate=new LinkedList<>();
			while(iterator.hasNext()){
				String itemString = (String) iterator.next();
				if (fileHashSet2.contains(itemString)) {
					two_file_duplicate.add(itemString);
				}
			}
			file1_count = fileHashSet1.size();
			file2_count = fileHashSet2.size();
			
			
		} catch (IOException e) {
			System.out.println("文件按行读入出错！");
		}
	}
	void dispaly()
	{
		System.out.println("两个文件总共的词汇表(即所有不重复的单词):");
		for (int i = 0; i < two_file_statistics.size(); i++) {
			System.out.print(two_file_statistics.get(i)+" ");
		}
		System.out.println();
		System.out.println("两个文件中的交集单词词汇表:");
		for (int i = 0; i < two_file_duplicate.size(); i++) {
			System.out.print(two_file_duplicate.get(i)+" ");
		}
		System.out.println();
		System.out.println("表 1 包含的单词总数: "+file1_count);
		System.out.println("表 2 包含的单词总数: "+file2_count);
	}
	

	public static void main(String[] args) {  
        Work7 work7 = new Work7();
        work7.wordsList("E:/1.txt", "E:/2.txt");
        work7.dispaly();
    }  

}

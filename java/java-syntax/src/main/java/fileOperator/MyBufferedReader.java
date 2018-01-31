package fileOperator;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MyBufferedReader {

	public static void main(String[] a) throws Exception {
		bufferedReaderAndWriter();
		// 使用指定的字符编码读取文件
		BufferedReader kbReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("E:/qa/1.txt")), "UTF-8"));
		
	}

	/**
	 * 用BufferedReader和BufferedWriter读取文件和写文件
	 */
	private static void bufferedReaderAndWriter() throws FileNotFoundException, IOException {
		BufferedReader idReader = new BufferedReader(new FileReader("E:/qa/1.txt"));
		String tmp = null;
		Map<Integer, String> idMap = new HashMap<>();
		int i = 0;
		while ((tmp = idReader.readLine()) != null) {
			idMap.put(i, tmp);
			i++;
			System.out.println("step1 i = " + i);
		}

		BufferedReader vecReader = new BufferedReader(new FileReader("E:/qa/qa20161018_10.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("E:/qa/qa_id_vec.txt"));
		i = 0;
		while ((tmp = vecReader.readLine()) != null) {
			tmp = tmp.replace(String.valueOf(i), idMap.get(i));
			writer.write(tmp + "\r\n");// 或者writer.newline()
			System.out.println("step2 i = " + i);
			i++;
		}

		writer.close();
		vecReader.close();
		idReader.close();
		System.err.println("over!!");
	}
}

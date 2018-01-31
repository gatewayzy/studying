package ai.tools.segment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;

import org.wltea.analyzer.IKSegmentation;
import org.wltea.analyzer.Lexeme;

/**
 * IKAnalyzer {@link http://git.oschina.net/wltea/IK-Analyzer-2012FF}
 */
public class IKAnalyzer {
	public static void main(String[] args) throws IOException {
		//sample();
		filesSeg();
	}

	/**分词示例
	 * @throws IOException
	 */
	private static void sample() throws IOException {
		String text = "IK Analyzer是一个结合词典分词和文法分词的中文分词开源工具包。它使用了全新的正向迭代最细粒度切分算法.支持细粒度切分和粗粒度切分。";
		InputStream inputStream = new ByteArrayInputStream(text.getBytes());
		Reader reader = new InputStreamReader(inputStream);
		IKSegmentation ikSegmentation = new IKSegmentation(reader, true);// true粗粒度切分
		Lexeme t;
		while ((t=ikSegmentation.next()) != null) {
			System.out.print(t.getLexemeText()+"|"+t.getLexemeType()+" ");
		}
	}
	
	/**
	 * 文件分词应用
	 * @throws IOException 
	 */
	private static void filesSeg() throws IOException {
		String srcDir = "C:/Users/delln/Desktop/yangyang/需要分词的txt";
		File dirFile = new File(srcDir);
		if (!dirFile.isDirectory()) {
			System.err.println("folder error!");
			return;
		}
		File[] files = dirFile.listFiles();
		String desDir = "C:/Users/delln/Desktop/yangyang/Java分词结果";
		for (File file : files) {
			File desFile = new File(desDir + "/"+file.getName());
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(desFile),"GBK"));
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GBK"));
			
			String tmpStrging = null;
			while ((tmpStrging = bufferedReader.readLine())!= null) {
				
				InputStream inputStream = new ByteArrayInputStream(tmpStrging.getBytes());
				Reader reader = new InputStreamReader(inputStream);
				IKSegmentation ikSegmentation = new IKSegmentation(reader, true);// true粗粒度切分
				Lexeme t;
				while ((t=ikSegmentation.next()) != null) {
					System.out.print(t.getLexemeText()+"  ");
					bufferedWriter.write(t.getLexemeText()+"  ");
				}
			}
			System.out.println();
			bufferedWriter.close();
			bufferedReader.close();
		}
	}
}

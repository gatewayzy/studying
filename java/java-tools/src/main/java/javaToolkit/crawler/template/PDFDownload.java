package javaToolkit.crawler.template;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

/**
 * Download by `org.officePOIpdf.commons.io.FileUtils`
 */
public class PDFDownload {

	/**
	 * @param args
	 * 		main
	 */
	public static void main(String[] args) {
		String url = "http://ietfreport.isoc.org/rfc/PDF";
		String[] list = readList(url);
		System.out.println("URL记录成功");
		for (String u : list) {
			String source = url + "/" + u;
			String des = "E:\\CrawlerByJsoup\\com\\"+"RFC" + File.separator + u;
			downloadAndSave(source, des);//下载文件
		}
		System.out.println("所有文件下载完成");
	}

	/**
	 * @param urlString
	 * 			含有文件列表的链接
	 * @return
	 * 			读取urlString参数的
	 */
	public static String[] readList(String urlString) {
		System.out.println("readList:"+urlString);
		String[] lists = new String[6734];
		try {
			URL url = new URL(urlString);
			Scanner scanner = new Scanner(url.openStream());
			int i = 0;
			int up = 6960; // 226
			while (scanner.hasNextLine() && i < up) {
				String line = scanner.nextLine();
				if (i >= 226) {
					lists[i - 226] = dealString(line);
				}
				i++;
			}
			scanner.close();
		} catch (MalformedURLException e) {
			System.out.println("URL异常");
		} catch (IOException e) {
			System.out.println("I/O异常");
		}
		return lists;
	}

	/**
	 * @param source
	 *          e.g.<li><a href="rfc7132.pdf"> rfc7132.pdf</a></li>
	 * @return result
	 *			处理后的文件名e.g.rfc7132.pdf
	 */ 
	public static String dealString(String source) {
		//System.out.println("dealString:"+source);
		String string = source;
		String result = string;
		String patterString = ">\\s.+.pdf";
		Pattern pattern = Pattern.compile(patterString);
		Matcher macher = pattern.matcher(string);
		while (macher.find()) {
			int start = macher.start();
			int end = macher.end();
			result = string.substring(start, end);
		}
		result = result.substring(2, result.length());
		//System.out.println("dealString:"+result);
		return result;
	}

	/**
	 * @param source
	 *            the url of PDF to be downloaded
	 * @param destination
	 *            the destination to be saved
	 */
	public static void downloadAndSave(String source, String destination) {
		try {
			URL url = new URL(source); 			// "http://ietfreport.isoc.org/rfc/PDF/rfc1341.pdf");
			File file = new File(destination);	// "rfc1341.pdf");
			FileUtils.copyURLToFile(url, file);	//下载文件
			System.out.println(source + "下载成功");
		} catch (MalformedURLException e) {
			System.out.println("URL异常");
		} catch (IOException e) {
			System.out.println("I/O异常");
		}
	}

}

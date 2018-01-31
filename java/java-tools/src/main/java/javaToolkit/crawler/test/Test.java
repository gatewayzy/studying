package javaToolkit.crawler.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test {
	public static void main(String args[]) throws IOException {
		//test1();
		//test2();
		//test3();
		Document document = Jsoup.connect("http://x19.me/blog/2014/11/26/poem-tone/").timeout(10000).get();
		System.out.println(document.html());
		Elements elements = document.getElementsByClass("mewslist");
		System.out.println(elements.toString());
	}
	
	/**
	 * 抓取网页的文字并写入text
	 */
	public static void test1() throws IOException{
		File WordSet;
		OutputStream out;
		BufferedWriter bw;
		WordSet = new File("E:\\CrawlerByJsoup\\Test\\test1.txt");
		out = new FileOutputStream(WordSet, false);
		bw = new BufferedWriter(new OutputStreamWriter(out, "utf-8"));
		
		Document document = Jsoup.connect("http://www.kmzyw.com.cn/pages/channel_426/").timeout(5000).get();
		Elements elements = document.getElementsByClass("mewslist");
		System.out.println(elements.toString());
		
		bw.write(elements.toString());
		bw.close();
		out.close();
	}
	
	/**
	 * 抓取网页的文字并写入text
	 */
	public static void test2() throws IOException{
		File WordSet;
		OutputStream out;
		BufferedWriter bw;
		WordSet = new File("E:\\CrawlerByJsoup\\Test\\test2.txt");
		out = new FileOutputStream(WordSet, false);
		bw = new BufferedWriter(new OutputStreamWriter(out, "utf-8"));
		
		Document document = Jsoup.connect("http://www.kmzyw.com.cn/pages/channel_772/20140414/772.1397438077000.9618.shtml").timeout(5000).get();
		Elements elements = document.getElementsByClass("news-con");
		System.out.println(elements.toString());
		
		bw.write(elements.toString());
		bw.close();
		out.close();
		
	}
	
	/**
	 * 抓取新闻
	 * @throws IOException 
	 */
	public static void test3() throws IOException {
		org.jsoup.nodes.Document doc = Jsoup.connect("http://www.satcm.gov.cn/").get();
		Elements elements = doc.getElementsByClass("news");
		if (null == elements){
			System.out.println("Nothing gained!");
		}

		List<String> list = new ArrayList<String>();
		for (Element e : elements) {
			Elements aElements = e.getElementsByTag("a");
			list.add(aElements.toString());
		}
		System.out.println(list.toString());
	}
}
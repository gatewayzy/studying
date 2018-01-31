package javaToolkit.crawler.template;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlerWithCookie {
	public static void main(String[] args) throws IOException,
			InterruptedException {
		/*
		 *抓取需要登录信息的网页，使用cookie，输出文字
		 * */
		Document doc = Jsoup
				.connect("http://cowork.cintcm.com/engine/detail")
				.userAgent(
						"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31")
				.data("record", "9", "channelid", "10140") 
				//User-Agent
				.cookie("JSESSIONID", "F286673BB59656677739B0E6907CB34E")
				.timeout(3000)
				.post();

		System.out.println(doc);
		Elements tables = doc.getElementsByTag("table");
		Element table = tables.get(1);
		Elements arr = table.getElementsByTag("tr");

		for (int i = 0; i < arr.size(); i++) {
			Element tr = arr.get(i);
			Elements tds = tr.getElementsByTag("td");
			String key = tds.get(0).text();
			String value = tds.get(0).text();
			// Ognl.setValue(map.getkey(''),aaa,value);
			System.out.println(key);
			System.out.println(value);
		}

	}

}

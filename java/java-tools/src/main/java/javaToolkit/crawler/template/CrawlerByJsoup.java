package javaToolkit.crawler.template;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 使用 Jsoup 爬取网页
 */
public class CrawlerByJsoup {
	public static void main(String args[]) throws IOException {
		/**
		 * 抓取网页的文字并写入text
		 */
		
		File WordSet;
		OutputStream out;
		BufferedWriter bw;
		WordSet = new File("E:\\CrawlerByJsoup\\com\\CrawlerByJsoup.txt");
		out = new FileOutputStream(WordSet, false);
		bw = new BufferedWriter(new OutputStreamWriter(out, "utf-8"));
		List<String> urlSet = new ArrayList<String>();
		int count = 0;

		Date now=new Date();
		SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		bw.write(myFmt.format(now));
		bw.newLine();
		
		for (int i = 1; i <= 372; i++) {
			org.jsoup.nodes.Document doc = Jsoup
					.connect(
							"http://www.tcm100.com/ShuJuKu/ZhongYiCiDian/PinYin"
									+ i + ".htm").timeout(5000).get();
			Elements links = doc.getElementsByTag("a");

			for (Element e : links) {
				String temp = e.attr("href");
				String word = e.text();
				// System.out.println(temp);
				if (temp.length() > 6) {
					if (temp.substring(0, 7).equals("zzZhong")) {
						urlSet.add(temp);
						System.out.println(word);
						count++;
						bw.write(word);
						bw.newLine();
					}
				}
			}

		}

		System.out.println(count);

		bw.close();
		out.close();
	}
}

package service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class MyJsoup implements Runnable {

	@Override
	public void run() {
		System.out.print("开始爬取百度...@" + System.currentTimeMillis());
		try {
			//Document document = Jsoup.connect("https://www.baidu.com/").timeout(1000).get();
			System.out.println(" ok");
		} catch (Exception e) {
			System.out.println(" fail");
		}
	}

}

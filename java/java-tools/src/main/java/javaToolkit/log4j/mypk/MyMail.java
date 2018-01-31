package javaToolkit.log4j.mypk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyMail {
	//没有对应的类名，会调用rootLogger和所有父级包对应的logger
	private static Log logger = LogFactory.getLog(MyMail.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.info("MyMail is infoing...");
	}

}

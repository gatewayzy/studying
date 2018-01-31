package javaToolkit.log4j.mypk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyData {
	// 没有对应的类名，会调用rootLogger和所有父级包对应的logger
	private static Log rootLogger = LogFactory.getLog("rootLogger");
	private static Log myLogger1 = LogFactory.getLog("myLogger1");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rootLogger.info("rootLogger is infoing...");
		myLogger1.info("myLogger1 is infoing...");
	}

}

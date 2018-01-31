package javaToolkit.log4j.myLogger;

import org.apache.log4j.Logger;

public class MyLogger {
	// 使用logger名称获取logger
	// 申明appender的logger，信息都会被rootLogger包括在内
	//private static Log logger1 = LogFactory.getLog("myLogger1");
	//private static Log logger2 = LogFactory.getLog("myLogger2");
	private static Logger logger1 =  Logger.getLogger("myLogger1");
	private static Logger logger2 =  Logger.getLogger("myLogger1");

	public static void main(String[] args) {
		// 多个输出流可以通过使用不同的输出级别区分appender
		if (logger1.isDebugEnabled()) {
			logger1.debug("myLogger1 isDebugEnabled...");
		}
		if (logger1.isInfoEnabled()) {
			logger1.info("myLogger1 isInfoEnabled...");
		}
		
		if (logger2.isDebugEnabled()) {
			logger2.debug("myLogger2 isDebugEnabled...");
		}
		if (logger2.isInfoEnabled()) {
			logger2.info("myLogger2 isInfoEnabled...");
		}
	}

}

package javaToolkit.log4j;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 这里用的是common-logging获取logger
 * 
 * @author dell
 *
 */
public class CommonLoggingRootLogger {
	// 配置中没有包含该类的logger，所以使用rootLogger
	private static Log logger = LogFactory.getLog(CommonLoggingRootLogger.class);

	public static void main(String[] args) {
		if (logger.isDebugEnabled()) {
			logger.debug("root logger debuging...");
		}
		if (logger.isInfoEnabled()) {
			logger.info("root logger info...");
		}
	}

}

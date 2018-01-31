package javaToolkit.log4j;

import org.apache.log4j.Logger;

/**log4j的logger
 * @author dell
 *
 */
public class Log4jRootLogger {
	private static Logger logger =  Logger.getRootLogger();

	public static void main(String[] args) {
		if (logger.isDebugEnabled()) {
			logger.debug("Log4jRootLogger root logger debuging...");
		}
		if (logger.isInfoEnabled()) {
			logger.info("Log4jRootLogger root logger info...");
		}
	}

}

package javaToolkit.log4j.mypk.dbpk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DbLogger {
	// 因为类所在包有对应logger，所以会调用rootLogger以及所有父包对应的logger
	private static Log logger = LogFactory.getLog(DbLogger.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.info("DbLogger is infoing...");

	}

}

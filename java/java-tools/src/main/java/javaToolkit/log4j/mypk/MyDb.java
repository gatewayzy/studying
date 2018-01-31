package javaToolkit.log4j.mypk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyDb {
	//如果有类名对应的logger就用对应的logger，并自动调用rootLogger，以及各级父类包对应的logger
	private static Log logger = LogFactory.getLog(MyDb.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.info("MyDb is infoing...");

	}

}

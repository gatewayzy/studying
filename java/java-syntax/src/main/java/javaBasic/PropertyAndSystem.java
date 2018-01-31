package javaBasic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * java 应用程序
 * 
 * @author dell
 *
 */
public class PropertyAndSystem {

	public static void main(String[] args) throws Exception {
		long begin = System.currentTimeMillis();
		System.err.println(">>> begin >>>");

		myProperties();

		mySystem();

		System.err.println(">>> end  >>>");
		long end = System.currentTimeMillis();
		long time = end - begin;
		System.err.println("耗时：" + time + "ms");

	}

	/**
	 * java获取系统属性、内置属性等
	 */
	private static void mySystem() {
		System.out.println("path : " + System.getenv("M2_HOME"));
		String[] names = { "os.name", "user.name", "user.home","java.vm.name" };
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i] + " : " + System.getProperty(names[i]));
		}
	}

	/**
	 * properties 学习
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void myProperties() throws FileNotFoundException, IOException {
		Properties myProperties = new Properties();
		FileInputStream in = new FileInputStream("src/main/resources/files/myProperties.properties");
		myProperties.load(in);
		System.out.println(myProperties.get("username"));
		System.out.println(myProperties.get("passwd"));
	}

}

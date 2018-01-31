package javaEE.database.jdbc.mysql;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class DbUtil {
	/**如果并发量比较多就不能设置成static*/
	private static Connection connection = null;
	private static Statement statement= null;
	private static ResultSet resultSet = null;
	
	/**数据库参数*/
	private static String url;
	private static String userName;
	private static String driver;
	private static String passwd;
	private static Properties properties;
	private static FileInputStream fileInputStream;
	
	//加载驱动，只需一次
	static{
		try {
			//读取数据库配置文件
			fileInputStream = new FileInputStream("src/main/resources/jdbc.properties");
			properties = new Properties();//实例化
			properties.load(fileInputStream);
			
			url = properties.getProperty("url");
			userName = properties.getProperty("userName");
			driver = properties.getProperty("driver");
			passwd = properties.getProperty("passwd");
			
			Class.forName(driver);//加载驱动类
		} catch (Exception e) {
			e.printStackTrace();
			//加载失败，可以退出程序了
		}
	}
	
	public static Connection getConnection() throws Exception{
		connection = DriverManager.getConnection(url, userName, passwd);
		return connection;
	}
	
	/**
	 * 测试入口
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		System.out.println(getConnection());
	}
	
}

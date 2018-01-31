package javaEE.database.jdbc.testConnection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 测试连接 SQL Server
 * 
 * @author delln
 *
 */
public class SQLServerConnect {
	public static final void main(String[] args) throws Exception {
		System.out.println("开始测试连接");

		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // 加载JDBC驱动
		String dbURL = "jdbc:sqlserver://10.15.82.58:1433;DatabaseName=EngineeringMedicine"; // 连接服务器和数据库test
		String userName = "sa"; // 默认用户名
		String userPwd = "cadalTCM220"; // 密码
		Connection dbConn = null;
		try {
			Class.forName(driverName);// 应将sqljdbc4j包加到build path
			System.out.println("Ok");
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
			System.out.println("Connection Successful!"); // 如果连接成功
															// 控制台输出Connection
															// Successful!
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			dbConn.close();
		}
	}

}

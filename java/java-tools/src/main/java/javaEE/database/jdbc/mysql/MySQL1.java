package javaEE.database.jdbc.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 * ResultSet
 * Statement
 * @author delln
 *
 */
public class MySQL1 {
	public static final void main(String[] args) throws Exception {
		/**类名 */
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/javatools";// 主协议：子协议/ip：port/db
		String user = "root";
		String pwd = "1234";
		Connection connection = null; //接口
		Statement statement = null;
		
		try {
			/**连接配置 */
			// 1 加载驱动类 
			Class.forName(driver);
			// 另一种方式如下，但不推荐，因为会加载两次driver
			// DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			// 2 获取连接
			connection = DriverManager.getConnection(url, user, pwd);
			// 3 通过statement向数据库发出sql指令
			//statement = connection.createStatement();//createStatement()不支持游标向后（向上）
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			int n = statement.executeUpdate("insert into user1 (name) values('zhangsan')");//此方法进行增改删CRUD之cud
			System.out.println(n + "行已添加到：" + connection);//输出connection可以查看数据库连接信息
			
			/**事务自动提交设置 */
			connection.setAutoCommit(false);//默认是自动提交
			connection.commit();
			
			/**ResultSet */
			ResultSet resultSet = statement.executeQuery("select * from user1");//此方法进行查create,retrive,update,del 
			while(resultSet.next()){//数据最后的next返回false
				System.out.println(resultSet.getInt(1) + resultSet.getString("name"));//游标所指数据
			}
			resultSet.beforeFirst();//重新使用resultSet游标，回到第一行
			System.out.println("重新使用游标");
			while(resultSet.next()){//数据最后的next返回false
				System.out.println(resultSet.getInt(1) + resultSet.getString("name"));//游标所指数据
			}
			System.out.println("resultSet的其他方法");
			resultSet.beforeFirst();//最前面的前面
			resultSet.afterLast();//最后面的后面
			resultSet.last();//定位到最后
			resultSet.previous();
			resultSet.absolute(2);//定位到第2行
			System.out.println(resultSet.getString("id"));
			
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();//不是自动提交的时候，commit之前的出错可以回滚
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				statement = null; // 使用垃圾回收机制
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				connection = null;
			}
		}
	}
}

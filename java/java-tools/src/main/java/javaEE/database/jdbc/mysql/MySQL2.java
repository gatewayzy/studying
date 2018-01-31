package javaEE.database.jdbc.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 * PreparedStatement
 * 
 * @author delln
 *
 */
public class MySQL2 {
	public static final void main(String[] args) throws Exception {
		/** 类名 */
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/javatools";// 主协议：子协议/ip：port/db
		String user = "root";
		String pwd = "1234";
		Connection connection = null; // 接口
		PreparedStatement ps = null;
		try {
			/** 连接配置 */
			// 1 加载驱动类
			Class.forName(driver);
			// 另一种方式如下，但不推荐，因为会加载两次driver
			// DriverManager.registerDriver(new com.mysql.jdbc.Driver());

			// 2 获取连接
			connection = DriverManager.getConnection(url, user, pwd);
			// 3 通过statement向数据库发出sql指令
			// statement =
			// connection.createStatement();//createStatement()不支持游标向后（向上）
			ps = connection.prepareStatement("select * from user1 where id = ? and name = ?");
			ps.setInt(1, 1);
			ps.setString(2, "zhangsan");
			/** ResultSet */
			ResultSet resultSet = ps.executeQuery();// 此方法进行查create,retrive,update,del
			while (resultSet.next()) {// 数据最后的next返回false
				System.out.println(resultSet.getInt(1) + resultSet.getString("name"));// 游标所指数据
			}

		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();// 不是自动提交的时候，commit之前的出错可以回滚
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ps = null; // 使用垃圾回收机制
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

	/**
	 * 将参数封装到vector中，使用PreparedStatement进行插入操作
	 * 
	 * @param connection
	 * @param vector
	 * @return
	 * @throws Exception
	 */
	static boolean insert(Connection connection, Vector<String> vector) throws Exception {
		String sql = "INSERT INTO research.data ( mingcheng, buwei, jieshi, yuanyin, biaoxian, "
				+ "tizheng, jiancha, jiancha2, yufang, zhiliao, jianbie, bingfa) VALUES "
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		for (int i = 0; i < vector.size(); i++) {
			ps.setString(i + 1, vector.get(i));
		}
		boolean flag = ps.execute();
		ps.close();
		return flag;
	}
}

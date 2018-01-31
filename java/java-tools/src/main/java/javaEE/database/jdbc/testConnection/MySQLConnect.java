package javaEE.database.jdbc.testConnection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 测试连接MySQL
 *
 * @author delln
 */
public class MySQLConnect {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/importDB";
        String user = "root";
        String pwd = "1234";
        Connection connection = null;

        try {
            /**加载驱动类*/
            Class.forName(driver);
//			connection = DriverManager.getConnection(url,user,pwd);
            connection = DriverManager.getConnection(url + "?user=" + user + "&password=" + pwd + "&testOnBorrow=true");
            if (connection != null) {
                System.out.println("Connection successfully!");
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            connection.close();
            System.out.println("finished...");
        }
    }

}

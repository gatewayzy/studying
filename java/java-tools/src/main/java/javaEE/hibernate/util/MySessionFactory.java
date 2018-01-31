package javaEE.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 写一个sessionFactory的工具类，且不允许继承，因为一个数据库最好只用一个sessionFactory
 * 
 * @author dell
 *
 */
final public class MySessionFactory {
	private static SessionFactory sessionFactory = null;

	private MySessionFactory() {
	}

	// 静态化的代码块，只会被执行一次
	static {
		// 创建Configuration来读取hibernate.cfg.xml，默认该文件名可以不用写
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		// 创建数据库的sessionFactory，这是一个重量级的对象，一个sessionFactory对应一个数据库
		sessionFactory = configuration.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}

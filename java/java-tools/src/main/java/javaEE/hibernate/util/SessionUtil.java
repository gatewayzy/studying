package javaEE.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 获取session的两种方法
 * 
 * @author dell
 *
 */
public class SessionUtil {
	private static SessionFactory sessionFactory = null;
	private static ThreadLocal<Session> threadLocal = new ThreadLocal<>();

	private SessionUtil() {
	}

	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	// 使用原生的openSession，获取全新的session
	public static Session openSession() {
		return sessionFactory.openSession();
	}

	// 通过threadLocal方法实现getCurrentSession的功能
	public static Session getCurrentSession() {
		Session session = threadLocal.get();
		// 判断是否得到
		if (session == null) {
			session = sessionFactory.openSession();
			// 将新建的session和线程进行绑定，之后获得的都是该session
			threadLocal.set(session);
		}
		return session;
	}

}

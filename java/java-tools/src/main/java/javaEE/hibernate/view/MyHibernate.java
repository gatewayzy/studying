package javaEE.hibernate.view;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javaEE.hibernate.domain.Customer;
import javaEE.hibernate.util.MySessionFactory;

/**
 * 使用hibernate实现数据库crud
 * 
 * @param args
 */
public class MyHibernate {
	public static void main(String[] args) {
		addCustomer();
		addCustomer();
		addCustomer();
		retrievalCustomer();
		updateCustomer();
		deleteCustomer();
	}

	/**
	 * 插入一条数据
	 */
	public static void addCustomer() {
		System.err.println("准备插入一个数据");
		// 创建Configuration来读取hibernate.cfg.xml，默认该文件名可以不用写
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		// 创建数据库的sessionFactory，这是一个重量级的对象，一个sessionFactory对应一个数据库
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		// 申请数据库session（connection）使用后必须记得关闭
		Session session = sessionFactory.openSession();
		// hibernate要求增改删操作必须使用事务，否则不会执行
		Transaction transaction = session.beginTransaction();
		// 添加一个customer
		Customer customer = new Customer();
		customer.setUserName("zhangsan");
		customer.setPasswd(new Date().toString());
		session.save(customer);
		transaction.commit();
		session.close();
		System.err.println("插入数据完成");
	}

	/**
	 * 查询一条数据
	 */
	private static void retrievalCustomer() {
		System.err.println("准备查询数据记录");
		// 通过工具获取session
		Session session = MySessionFactory.getSessionFactory().openSession();
		// 获取主键=2的对象，通过类名反射获取mapping
		Customer customer = session.load(Customer.class, 2);
		System.err.println("查询到主键为2的customer姓名为：" + customer.getUserName());
	}

	/**
	 * 更新一条数据
	 */
	private static void updateCustomer() {
		System.err.println("准备修改数据记录");
		// 通过工具获取session
		Session session = MySessionFactory.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		// 获取主键=3的对象，通过类名反射获取mapping
		Customer customer = session.load(Customer.class, 3);
		// set会产生数据游离状态，hibernate会检测到修改，所以commit会发生改变
		customer.setUserName(customer.getUserName() + "1");
		customer.setPasswd(new Date().toString());
		transaction.commit();
		session.close();
		System.err.println("修改主键3的姓名为：" + customer.getUserName() + "1");

	}

	/**
	 * 删除一条数据
	 */
	private static void deleteCustomer() {
		System.err.println("准备删除记录");
		// 通过工具获取session
		Session session = MySessionFactory.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			// 获取主键=1的对象，通过类名反射获取mapping
			Customer customer = session.load(Customer.class, 1);
			session.delete(customer);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.err.println("删除主键1的记录成功");
	}

}

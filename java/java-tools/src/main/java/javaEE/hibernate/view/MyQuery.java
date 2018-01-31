package javaEE.hibernate.view;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javaEE.hibernate.domain.Customer;
import javaEE.hibernate.util.SessionUtil;

public class MyQuery {
	public static void main(String[] aStrings) {
		// query();
		criteria();

	}

	private static void query() {
		Session session = SessionUtil.openSession();
		Transaction transaction = session.beginTransaction();

		// 获取query引用，这里用的还是Pojo对象不是表名，条件中的可以是表的字段名也可以是Pojo成员名，推荐是Pojo成员名
		Query query = session.createQuery("from Customer where userName='zhangsan'");
		// Query query = session.createQuery("from Customer where id=1);
		List<Customer> list = query.list();
		for (Customer customer : list) {
			System.out.println("查询到的数据信息为：");
			System.out.println(customer.getId() + " " + customer.getUserName() + " " + customer.getPasswd());
		}
		session.close();
	}

	private static void criteria() {
		Session session = SessionUtil.openSession();
		Transaction transaction = session.beginTransaction();

		Criteria criteria = session.createCriteria(Customer.class).add(Restrictions.like("userName", "zhang%"))
				.setMaxResults(2).addOrder(Order.desc("id"));
		List<Customer> list = criteria.list();
		for (Customer customer : list) {
			System.out.println("查询到的数据信息为：");
			System.out.println(customer.getId() + " " + customer.getUserName() + " " + customer.getPasswd());
		}
		session.close();
	}
}

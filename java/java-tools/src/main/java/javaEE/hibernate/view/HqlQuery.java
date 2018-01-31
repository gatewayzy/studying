package javaEE.hibernate.view;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javaEE.hibernate.domain.Customer;
import javaEE.hibernate.util.SessionUtil;

public class HqlQuery {
	public static void main(String[] args) {
		//query1();
		//query2();
		//query3();
	}

	private static void query3() {
		Session session = SessionUtil.openSession();
		Transaction transaction = session.beginTransaction();
		Query query1 = session.createQuery("from Customer where id=:a");
		query1.setString("a","2");
		Query query2 = session.createQuery("from Customer where id=?");
		query2.setString(0,"2");
		List<Customer> list  = query1.list();
		for (Customer customer : list) {
			System.out.println(customer.getUserName() + " " + customer.getId());
		}
		System.out.println();
		transaction.commit();
		session.close();
	}

	private static void query2() {
		Session session = SessionUtil.openSession();
		Transaction transaction = session.beginTransaction();
		// 检索所有的customer，是从对象
		List<Object[]> list = session.createQuery("select userName,passwd from Customer ").setFirstResult(10).setMaxResults(20).list();
		for (Object[] customer : list) {
			System.out.println(customer[0].toString() + " " + customer[1].toString());
		}
		System.out.println();
		transaction.commit();
		session.close();
	}

	private static void query1() {
		Session session = SessionUtil.openSession();
		Transaction transaction = session.beginTransaction();
		// 检索所有的customer，是从对象
		List<Customer> list = session.createQuery("from Customer").list();
		for (Customer customer : list) {
			System.out.println(customer.getUserName() + " " + customer.getId());
		}
		System.out.println();
		transaction.commit();
		session.close();
	}

}

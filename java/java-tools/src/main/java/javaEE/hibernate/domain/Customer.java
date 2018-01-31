package javaEE.hibernate.domain;

import java.io.Serializable;

/**
 * 序列化实现对象的唯一标识，便于网络传输等
 * 
 * @author dell
 *
 */
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String userName;
	private String passwd;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}

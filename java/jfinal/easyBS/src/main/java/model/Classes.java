package model;

import com.jfinal.plugin.activerecord.Model;

/*
mysql> desc classes;
+------------+--------------+------+-----+---------+-------+
| Field      | Type         | Null | Key | Default | Extra |
+------------+--------------+------+-----+---------+-------+
| claID      | int(10)      | NO   | PRI | 0       |       |
| claName    | varchar(255) | YES  |     | NULL    |       |
| clacharger | varchar(255) | YES  |     | NULL    |       |
+------------+--------------+------+-----+---------+-------+
3 rows in set
*/

public class Classes extends Model<Classes>{
	
	/*获取更多方法，请查阅JFinal的Model类介绍*/
	public static final Classes dao = new Classes();
	/*dao对象是全局共享的，只能用于数据库查询（查改删），
	 * 不能用于数据承载（增），数据承载需要使用new Classes().set("name","James").save()*/

	/**
	// 创建name属性为James,age属性为25的User对象并添加到数据库
	new User().set("name", "James").set("age", 25).save();
	// 删除id值为25的User
	User.dao.deleteById(25);
	// 查询id值为25的User将其name属性改为James并更新到数据库
	User.dao.findById(25).set("name", "James").update();
	// 查询id值为25的user, 且仅仅取name与age两个字段的值
	User user = User.dao.findById(25, "name, age");
	// 获取user的name属性
	String userName = user.getStr("name");
	// 获取user的age属性
	Integer userAge = user.getInt("age");
	// 查询所有年龄大于18岁的user
	List<User> users = User.dao.find("select * from user where age>18");
	// 分页查询年龄大于18的user,当前页号为1,每页10个user
	Page<User> userPage = User.dao.paginate(1, 10, "select * ", "from user where age > ?", 18);
	 * */
	
}

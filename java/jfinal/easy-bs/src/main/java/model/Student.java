package model;

import com.jfinal.plugin.activerecord.Model;

/*
mysql> desc student;
+--------------+--------------+------+-----+---------+-------+
| Field        | Type         | Null | Key | Default | Extra |
+--------------+--------------+------+-----+---------+-------+
| stuID        | int(10)      | NO   | PRI | 0       |       |
| stuName      | varchar(255) | YES  |     | NULL    |       |
| stuSex       | varchar(5)   | YES  |     | NULL    |       |
| stuAge       | int(5)       | YES  |     | NULL    |       |
| registerTime | date         | YES  |     | NULL    |       |
+--------------+--------------+------+-----+---------+-------+
5 rows in set
*/
public class Student extends Model<Student>{
	public static final Student dao = new Student();
}

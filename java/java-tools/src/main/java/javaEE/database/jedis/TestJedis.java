package javaEE.database.jedis;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * java操作redis数据库<br/>
 * 
 * @author Administrator
 *
 */
public class TestJedis {

	public static void main(String[] a) {
		
		System.err.println("starting...");

		// 获取链接
		//Jedis jedis = new Jedis("10.15.82.57", 6379);
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		//由于redis存在安全漏洞，所以redis服务器必须设置密码。
		jedis.auth("CADALtcm220");
		// 测试是否连通
		System.out.println("数据库连通状态为：" + jedis.ping());
/*
		getKeys(jedis);
		crudString(jedis);
		crudList(jedis);
		
		// 还有hash、set、zset的操作

		// 关闭连接
		jedis.close();
		// jedis.shutdown();//关闭redis server
 
*/
		System.err.println("over!!!");
	}

	/**
	 * redis存取list类型数据
	 * 
	 * @param jedis
	 */
	private static void crudList(Jedis jedis) {
		System.out.println(">>> redis存取list类型数据 >>>");
		jedis.lpush("aList", "element-a");
		jedis.lpush("aList", "element-b");
		jedis.lpush("aList", "element-c");
		List<String> list = jedis.lrange("aList", 0, 1);
		System.out.println("aList对应的list中前两个元素中为：");
		for (String element : list) {
			System.out.println(element);
		}
	}

	/**
	 * redis主键遍历与选取
	 * 
	 * @param jedis
	 */
	private static void getKeys(Jedis jedis) {
		System.out.println(">>> redis主键遍历与选取 >>>");
		Set<String> keys = jedis.keys("*");
		System.out.println("redis中存放的主键：键值如下");
		for (String key : keys) {
			System.out.println(key + " : " + jedis.get(key));
		}

		Set<String> key2 = jedis.keys("str*");
		System.out.println("redis中存放的对应str*的主键：键值如下");
		for (String key : key2) {
			System.out.println(key + " : " + jedis.get(key));
		}
	}

	/**
	 * 值为String类型的crud操作
	 */
	private static void crudString(Jedis jedis) {
		System.out.println(">>> String类型的CRUD操作 >>>");
		jedis.set("aString", "Redis支持String、List、Hash、Set、Ordered Set数据类型，所有操作都是原子性的，速度极快，支持持久化、主从备份");
		System.out.println("插入成功！\n查询到插入的'aString'对应的值为：" + jedis.get("aString"));
		jedis.set("aString", "相同的键会覆盖之前的键值对");
		System.out.println("查询到插入的'aString'对应的值为：" + jedis.get("aString"));
		jedis.del("aString");
		System.out.println("删除'aString'对应的键值对，删除之后为：" + jedis.get("aString"));
	}

}

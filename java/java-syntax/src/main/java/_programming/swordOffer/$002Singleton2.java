package _programming.swordOffer;

/**
 * java 单例模式2<br> 
 * 不推荐，多线程的情况可以用，但是是懒汉式，同步锁的消耗较大，只在方法1的getInstance()中添加了synchronized关键词<br>
 * 注解：在解法一的基础上加上了同步锁，使得在多线程的情况下可以用
 */
public class $002Singleton2 {

	private $002Singleton2() {
	}

	private static $002Singleton2 instance = null;

	public static synchronized $002Singleton2 getInstance() {
		if (instance == null) {
			instance = new $002Singleton2();
		}
		return instance;
	}

}

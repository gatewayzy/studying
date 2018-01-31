package _programming.swordOffer;

/**
 * java 单例模式3<br>
 * 可行，多线程的情况可以用，修改方法2的getInstance()的同步机制，不必进行方法级锁定，在创建实例时锁定即可<br>
 * 注解：只有当instance为null时，需要获取同步锁，创建一次实例。当实例被创建，则无需试图加锁。<br>
 * 缺点：用双重if判断，复杂，容易出错。
 */
public class $002Singleton3 {

	private static $002Singleton3 instance = null;

	private $002Singleton3() {
	}

	public static $002Singleton3 getInstance() {
		if (instance == null) {
			synchronized ($002Singleton3.class) {
				if (instance == null) {
					instance = new $002Singleton3();
				}
			}
		}
		return instance;
	}

}

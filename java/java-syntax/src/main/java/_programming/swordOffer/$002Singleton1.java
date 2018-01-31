package _programming.swordOffer;

/**
 * java 单例模式1
 * 注解:Singleton的静态属性instance中，只有instance为null的时候才创建一个实例，构造函数私有，确保每次都只创建一个，避免重复创建。<br>
 * 缺点：只在单线程的情况下正常运行，在多线程的情况下，就会出问题。
 * 例如：当两个线程同时运行到判断instance是否为空的if语句，并且instance确实没有创建好时，那么两个线程都会创建一个实例。
 * 
 */
public class $002Singleton1 {

	private $002Singleton1() {
	}

	private static $002Singleton1 instance = null;

	public static $002Singleton1 getInstance() {
		if (instance == null) {
			instance = new $002Singleton1();
		}
		return instance;
	}

}

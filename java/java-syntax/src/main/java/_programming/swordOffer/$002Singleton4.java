package _programming.swordOffer;

/**
 * java 单例模式4<br>
 * 推荐，多线程的情况可以用，饿汉式，不管有没有需要使用instance，都会在类初次调用就会初始化静态instance一次，无法按需创建<br>
 * 注解：初试化静态的instance创建一次。如果我们在Singleton类里面写一个静态的方法不需要创建实例，它仍然会早早的创建一次实例。而降低内存的使用率。<br>
 * 缺点：没有lazy loading的效果，从而降低内存的使用率。
 */
public class $002Singleton4 {

	private static $002Singleton4 instance = new $002Singleton4();

	private $002Singleton4() {
	}

	// 类在加载时就已经创建了static的属性一次
	public static $002Singleton4 getInstance() {
		return instance;
	}

}

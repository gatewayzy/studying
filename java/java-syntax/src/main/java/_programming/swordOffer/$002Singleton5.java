package _programming.swordOffer;

/**
 * java 单例模式5<br>
 * 推荐，多线程的情况可以用，使用私有内部类，按需创建<br>
 * 注解：私有内部类singletonHolder，别人无法调用他创建实例<br>
 * $002Singleton5类在初次调用getInstance()才会调用加载singletonHolder创建实例，$002Singleton5之后不会调用static方法
 */
public class $002Singleton5 {

	private $002Singleton5() {
	}

	private static class singletonHolder {
		public static final $002Singleton5 instance = new $002Singleton5();
	}

	public static $002Singleton5 getInstance() {
		return singletonHolder.instance;
	}

}

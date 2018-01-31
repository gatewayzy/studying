package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 利用类的元素数据实现反射机制
 * 
 * @author dell
 *
 */
public class JavaReflect {

	public static void main(String[] args) throws Exception {
		reflectByClassLoader();

		classLoader();
		

	}

	/**
	 * <p>
	 * classLoader进行装载、链接、初始化步骤。装载是查找和导入class文件。<br>
	 * 链接是执行校验class文件、准备静态变量的空间、解析将符号引用转成直接引用<br>
	 * 初始化时对类的静态变量、静态代码块进行初始化
	 * </p>
	 * classLoader有三个，先是基于c++的根加载器看不到返回null，负责jre如rt.jar。<br>
	 * 根加载器加载ExtClassLoader，负责拓展目录ext中的jar类包。<br>
	 * ExtClassLoader加载AppClassLoader，负责当前Classpath路径下的类包<br>
	 * AppClassLoader加载了当前运行类<br>
	 */
	private static void classLoader() {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		System.out.println("current classLoader: " + classLoader);
		System.out.println("parent classLoader: " + classLoader.getParent());
		System.out.println("grandfather classLoader: " + classLoader.getParent().getParent());
	}

	/**
	 * 通过ClassLoader、Class、Method、Constructor等反射类实例化一个对象
	 * 
	 * @throws Exception
	 */
	private static void reflectByClassLoader() throws Exception {
		// 通过classLoader加载类对象
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Class refletCarClass = classLoader.loadClass("study.language.java.javaBasic.ReflectCar");
		// 通过类的构造器实例化对象
		Constructor<ReflectCar> constructor = refletCarClass.getDeclaredConstructor(null);
		ReflectCar reflectCar = constructor.newInstance(null);

		// 通过放射方法设置属性
		// 方法名必须存在
		Method setName = refletCarClass.getMethod("setName", String.class);
		setName.invoke(reflectCar, "反射name");
		Method setColor = refletCarClass.getMethod("setColor", String.class);
		setColor.invoke(reflectCar, "反射color");

		System.out.println(reflectCar.toString());
		
		// 反射机制可以绕过类中的访问限制，如private、protected的属性和方法等
		Field name = refletCarClass.getDeclaredField("name");
		name.setAccessible(true); // 取消java访问限制
		name.set(reflectCar, "私有颜色访问");
		System.out.println(reflectCar.toString());
		
	}

}
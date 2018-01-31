package jvm;

/**
 * String.intern()的作用是：如果string内容存在于常量池则返回常量池中的引用，不存在则将string添加到常量池并返回池中引用
 * 
 * @author dell
 *
 */
public class _01StringIntern {

	public static void main(String[] args) {
		// String string1 = new StringBuilder("计算机").append("软件").toString();
		
		// jdk1.6中将堆设置为永久代，添加string到常量池的动作为：复制到常量池并返回池中引用
		// jdk1.7中将堆去永久代设置，添加string到常量池的动作为：将首次引用添加到常量池中，返回引用，所以实质上就是首次实例的引用
		
		String string1 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(string1.intern() == string1);

		// "java""main"在程序中不是首次出现，个人猜测也许是内置的
		String string2 = new StringBuilder("ja").append("va").toString();
		System.out.println(string2.intern() == string2);

		String string3 = new StringBuilder("ma").append("in").toString();
		System.out.println(string3.intern() == string3);

		String string4 = new StringBuilder("maaa").append("insdf").toString();
		System.out.println(string4.intern() == string4);
		
		// 人工调用垃圾回收
		System.gc();
	}

}

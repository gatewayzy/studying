package jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class _02GC1 {
	static _02GC1 staticA = null;

	private String name;

	public _02GC1() {
	}

	public _02GC1(String name) {
		this.name = name;
	}

	@Override
	protected void finalize() throws Throwable {
		// Object有clone、equals、hashCode、finalize、toString方法
		// 可以通过source->override/implement method 进行覆盖
		super.finalize();
		System.out.println("F-Queue中的这个对象要被回收了，使用他最后的自救机会！");
		staticA = this; // 只要回归GC Roots引用链就自救成功，这里构建一个指向方法的调用者的引用以实现自救
	}

	public static void main(String[] args) throws Exception {
		reference();
		gcObj();
	}

	// 判断对象生死
	private static void gcObj() throws InterruptedException {
		// 法一 引用计数器：引用就+1，为0标记为垃圾，简单但是不好解决对象循环引用的问题
		// 法二 可达性分析算法：从GC Roots开始是否有引用链，引用可达的一定不会回收，主流jvm使用的方法
		// （虚拟机栈的本地变量表、本地方法栈的本地方法、方法区的类静态属性 、方法区的常量）所引用的对象才视为GC Roots的对象

		// 对象销毁的两个步骤：
		// 1.GC Roots不可达则标记该对象到F-Queue队列
		// 2.在F-Queue中未执行到该对象的finalize()（如未覆盖或已执行过或未来得及执行），则标记给gc，基本就是死定了
		// 由一个专门的Finalizer()线程去执行F-Queue中各个finalize()，但是该线程运行级别很低，需要一定等待时间，级别太高可能导致gc卡死

		// 例子 1
		staticA = new _02GC1();
		staticA = null;
		System.gc(); // 1. 引用不可达
		Thread.sleep(500); // 等待Finalizer()线程运行

		String ret = "alive";
		if (staticA == null) {
			ret = "dead";
		}
		System.out.println(ret);

		// 例子 2
		// 下面代码中，gc是栈中的变量，堆中有3个对象，staticA = this指向的是栈中的救不到
		_02GC1 gc = new _02GC1("1");
		gc = new _02GC1("2");
		gc = new _02GC1("3");
		gc = null; //
		System.gc(); // 3个对象都要被gc检测为引用不可达
		Thread.sleep(500); // 等待Finalizer()线程运行，用各个对象的finalize()方法自救，但是staticA被覆盖只能救到1个对象
		System.out.println("救到的一个对象是：" + staticA.name);
	}

	/** 引用的种类 */
	private static void reference() {
		System.err.println("引用的分类：查看代码注释");
		// 强引用 strong reference
		String str1 = "string1";
		String str2 = new String();

		// 软引用 soft reference
		// 表示对象有用但非必要，如果内存够就不被gc，如果gc一次还要OOM就尝试第二次gc并回收soft，还OOM就抛出OOM
		SoftReference<String> softReference = new SoftReference<String>(str1);

		// 弱引用 weak reference 表示对象非必须，发生gc就会回收
		WeakReference<String> weakReference = new WeakReference<String>(str1);

		// 虚引用，完全不会影响对象的生存时间，只是在对象被gc时收到一个系统通知
		PhantomReference<String> phantomReference = new PhantomReference<String>(str2, null);

	}

}

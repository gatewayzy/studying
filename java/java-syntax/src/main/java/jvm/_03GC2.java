package jvm;

/*
 * VM：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 
 * 分别表示输出gc信息，堆最小20MB，堆最大20M， 堆的新生代10M（所以老生代10M），输出gc信息，
 * 堆的新生代的gc使用8:1（Eden区占0.8*10M=8M，两个survivor区分别0.1*10=1M）
 */
public class _03GC2 {
	public static final int OneMB = 1024 * 1024;

	public static void main(String[] args) {
		byte[] a1, a2, a3, a4;
		// Eden区8M，survivor各1M，新生代可用为8+1M，1M转存空间
		a1 = new byte[2 * OneMB]; // 占Eden 2M
		a2 = new byte[2 * OneMB]; // 占Eden 2M
		a3 = new byte[2 * OneMB]; // 占Eden 2M
		// Eden被占6M，新生代还可用3
		// 要分配下面的4，于是进行Minor gc新生代gc，尝试将存活的对象复制到转存survivor，但是1M存不下6M
		// 于是通过担保机制将存活对象全部移到老年代，新生代只有Eden新加的a4，老年代是之前的3个
		a4 = new byte[4 * OneMB];// 分配a4需要Minor gc
		// jdk1.6下堆有新生代、老年代、永久代，运行结果是占用 6M 4M 3031K
		// jdk1.7 下堆有新生代、老年代、永久代 ，运行结果是占用 7M 4M 2568K
		// gc选择器不同，实现算法也在更新
		System.out.println("over!!!");
	}

}

package javaBasic.comparator;

import java.text.CollationKey;
import java.text.Collator;
import java.util.Comparator;

/**
 * 实现Comparator
 * 
 * @author dell
 *
 */
public class ChComparator implements Comparator {
	// 中文比较
	private Collator chCollator = Collator.getInstance(java.util.Locale.CHINA);
	// 默认是英文比较
	private Collator collator = Collator.getInstance(java.util.Locale.CHINA);

	public ChComparator() {
	}

	/**
	 * 将o1与o2分别转换为string进行比较，返回1,0,-1 分别代表大于，等于，小于
	 * 
	 * @param o1
	 *            Object
	 * @param o2
	 *            Object
	 * @return int
	 */
	public int compare(Object o1, Object o2) {
		// 把字符串转换为一系列比特，它们可以以比特形式与 CollationKeys 相比较
		CollationKey key1 = chCollator.getCollationKey(o1.toString());
		CollationKey key2 = chCollator.getCollationKey(o2.toString());
		return key1.compareTo(key2);
		// 要想不区分大小写进行比较用o1.toString().toLowerCase()
	}
}

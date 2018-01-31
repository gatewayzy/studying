package javaBasic.comparator;

import java.text.Collator;
import java.util.*;

/**
 * 中文排序和数据排序等排序
 * 
 * @author dell
 *
 */
public class SortOrder {

	public static void main(String[] args) {
		SortOrder sortOrder = new SortOrder();
		sortOrder.arraySort();
		sortOrder.chWordSort();
		sortOrder.listSort();
		sortOrder.mapSort();

	}

	/** 英文 一维数组 升序排序 */
	public void arraySort() {
		// String[] sortArray = { "中山", "汕尾", "广州", "汕头", "阳江" };//不支持中文
		String[] sortArray = { "Oscar", "Charlie", "Ryan", "Adam", "David" };
		Arrays.sort(sortArray);
		for (int i = 0; i < 5; i++) {
			System.out.print((String) sortArray[i] + "  ");
		}
		System.out.println();
	}

	/** 中文 一维数组 升序排序 */
	public void chWordSort() {
		Comparator<Object> com = Collator.getInstance(java.util.Locale.CHINA);
		String[] newArray = { "中山", "汕头", "广州", "安庆", "阳江", "南京", "武汉", "北京", "安阳", "北方" };
		Arrays.sort(newArray, com);
		for (String i : newArray) {
			System.out.print(i + "  ");
		}
		System.out.println();
	}

	/** 中文 list 升序 */
	public void listSort() {
		List list = new ArrayList();
		list.add("中山");
		list.add("汕头");
		list.add("广州");
		list.add("安庆");
		list.add("阳江");
		list.add("南京");
		list.add("武汉");
		list.add("北京");
		list.add("安阳");
		list.add("北方");
		ChComparator comparator = new ChComparator();
		Collections.sort(list, comparator);
		for (int i = 0; i < list.size(); i++) {
			// 因为ArrayList实现的是RandomAccess 随机访问接口。使用get()要比迭代的效率高。
			// 如果实现的是SequenceAccess(顺序访问接口。如：LinkList),使用迭代的效率高。
			System.out.print(list.get(i) + "  ");
		}
		System.out.println();
	}

	/** 中文 treeMap 升序 */
	public void mapSort() {
		// 按照键值排序
		ChComparator comparator = new ChComparator();
		Map sortMap = new TreeMap(comparator);
		sortMap.put("中山", "a");
		sortMap.put("汕头", "b");
		sortMap.put("广州", "c");
		sortMap.put("安庆", "a");
		sortMap.put("阳江", "b");
		sortMap.put("南京", "c");
		sortMap.put("武汉", "a");
		sortMap.put("北京", "b");
		sortMap.put("安阳", "c");
		sortMap.put("北方", "c");
		// 注意：每次对TreeMap进行put()时，TreeMap都会自动调用它的compare(key,Entry.key)
		Collection col = sortMap.keySet();
		Iterator it = col.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + "  ");
		}
		System.out.println();
	}

}

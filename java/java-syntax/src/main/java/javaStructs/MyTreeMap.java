package javaStructs;

import java.util.*;

public class MyTreeMap {
	/**
	 * TreeMap默认实现了comparable接口
	 * 
	 * @param a
	 */
	public static void main(String[] a) {
		Map<Double, String> concept_map = new TreeMap<>();
		// 添加数据将使用默认实现的comparable方法
		concept_map.put(3.5, "java");
		concept_map.put(2.5, "data");
		concept_map.put(4.5, "mining");
		concept_map.put(5.5, "machine");
		concept_map.put(6.5, "learning");

		List<Double> values = new ArrayList<>(concept_map.keySet());

		Collections.reverse(values);

		for (double value : values) {
			System.out.println(value + ":" + concept_map.get(value));
		}
	}
}

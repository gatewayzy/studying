package javaStructs;

import java.util.Arrays;

public class MyString {

	public static void main(String[] args) {
		System.out.println("string".length()); // string 是对象需要用方法
		int[] a = new int[5];
		System.out.println(a.length); // 数组是内置对象，需要用属性
		System.out.println(Arrays.toString(a));
		int[] ba = {1,2,3};
		int[] bb = new int[]{1,2,3};
		System.out.println(Arrays.toString(ba));
		System.out.println(Arrays.toString(bb));
	}

}

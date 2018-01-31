package _programming.algorithms.sort;

/*
 * 直接插入排序
 * 核心思想：保证上一轮数据有序，下一轮将大于新加数的数字全部后移一位
 * 空间O阶：额外空间1
 * 时间O阶：最好时只比较n-1次不移动，为On，最坏时比较和移动Onn
 * 常用于 ：向有序列中插入数据
 */
public class StraightInsertionSort {

	/**
	 * 第1个数有序，用循环对之后的每个数进行排序
	 * 排序内容为：用一个变量存当前要插入的数，可用空间为：有序空间+当前变量原来空间，对有序空间大端查找，将大于当前数的依次后移，插入当前数
	 * 
	 * @return
	 */
	public static int[] insertSort(int[] a) {
		int length = a.length;// 数组长度，将这个提取出来是为了提高速度。
		int insertNum;// 要插入的数

		for (int i = 1; i < length; i++) {// 插入的次数
			insertNum = a[i];// 要插入的数
			int j = i - 1;// 已经排序好的序列元素个数
			while (j >= 0 && a[j] > insertNum) {// 序列从后到前循环，将大于insertNum的数向后移动一格
				a[j + 1] = a[j];// 元素移动一格
				j--;
			}
			a[j + 1] = insertNum;// 将需要插入的数放在要插入的位置。
		}

		return a;
	}

}

package _programming.algorithms.sort;

/*
 * 简单选择排序
 * 常用于取序列中最大或最小的几个数
 * 
 * 
 * 遍历整个序列，将最小的数放在最前面。
 * 遍历剩下的序列，将最小的数放在最前面。
 * 重复第二步，直到只剩下一个数。
 */
public class SimpleSelectionSort {

	public void selectSort(int[] a) {
		int length = a.length;
		for (int i = 0; i < length; i++) {// 循环次数
			int key = a[i];
			int position = i;
			for (int j = i + 1; j < length; j++) {// 选出最小的值和位置
				if (a[j] < key) {
					key = a[j];
					position = j;
				}
			}
			a[position] = a[i];// 交换位置
			a[i] = key;
		}
	}
}

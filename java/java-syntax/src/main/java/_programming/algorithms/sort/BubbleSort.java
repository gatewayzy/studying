package _programming.algorithms.sort;

/*
 * 冒泡排序 
 * 一般不用 
 * 核心思想：每一轮两两比较，交换顺序，知道没有相反顺序的
 * 基本优化：设置flag，每一轮假设要排序，该轮都没有发生交换则不用再开始剩下的轮了 
 * 时间O阶：最好时比较n不移动为On，最坏时比较和移动为Onn
 */
public class BubbleSort {
	public static void main(String[] a) {
		int [] b = new int[] {7,6,0,3,2,1,4};
		bubbleSort(b);
	}
	
	public static int[] bubbleSort(int[] a) {

		int temp;
		int len = a.length;
		boolean noOrder = true;

		for (int i = 0; i < len && noOrder; i++) {
			noOrder = false;

			for (int j = 0; j < len - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					noOrder = true;
				}
			}
		}

		return a;
	}

}

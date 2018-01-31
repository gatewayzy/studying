package _programming.algorithms.sort;

/*
 * 日常操作中常见的排序方法有：冒泡排序、快速排序、选择排序、插入排序、希尔排序，甚至还有基数排序、鸡尾酒排序、桶排序、鸽巢排序、归并排序等。
 * 
 * 							-- 插入排序 ：	直接插入排序3、希尔排序
 * 							-- 选择排序 ：	简单选择排序2、堆排序
 * 		-- 内部排序（只用内存）	-- 交换排序：	冒泡排序1、快速排序
 * 							-- 归并排序
 * 							-- 基数排序	
 * 排序
 * 
 *		-- 外部排序（内存外存）	
 *
 * */
/**
 * 排序稳定：排序按照关键字，只有其他字段不一样时，如果排序后保持了之前顺序则为稳定，否则称不稳定<br>
 * 如 1 2、 1 3排成了1 3、1 2就是不稳定
 */

/*
 * 所需辅助空间最多：归并排序 所需辅助空间最少：堆排序 平均速度最快：快速排序 不稳定：快速排序，希尔排序，堆排序。
 * 
 */
// 参考书籍《大话数据结构》
// 参考文章：http://www.toutiao.com/a6328994626498904321/
public class PackageInfo {

	public static void main(String[] args) {

		int[] a = new int[] { 32, 43, 23, 13, 5 };

		printArray(BubbleSort.bubbleSort(a));
		printArray(StraightInsertionSort.insertSort(a));
	}

	public static void printArray(int[] a) {
		for (int i : a) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}

}

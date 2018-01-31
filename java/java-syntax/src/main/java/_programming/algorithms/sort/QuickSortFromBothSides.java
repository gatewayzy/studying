package _programming.algorithms.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 每趟排序选一个基准（如第一个值），两端用指针向中间逼近，前面大于base，后面小于base的二者进行交换，直到中间位置。
 * 递归前面到中间位置、中间位置到后面
 */
public class QuickSortFromBothSides {
    public static void main(String[] a) {
        int[] b = new int[]{7, 6, 0, 3, 2, 1, 4};
        quickSort(b, 0, b.length - 1);
        System.out.println(Arrays.toString(b));
    }

    public static void quickSort(int[] numbers, int start, int end) {
        if (start < end) {
            int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）
            int temp; // 记录临时中间值
            int i = start, j = end;
            do {
                while ((numbers[i] < base) && (i < end))
                    i++;
                while ((numbers[j] > base) && (j > start))
                    j--;
                if (i <= j) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (start < j)
                quickSort(numbers, start, j);
            if (end > i)
                quickSort(numbers, i, end);
        }
    }

}

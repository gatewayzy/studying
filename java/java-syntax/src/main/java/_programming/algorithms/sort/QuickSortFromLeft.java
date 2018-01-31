package _programming.algorithms.sort;

import java.util.Arrays;

/**
 * 快速排序：两个指针从前面向后面逼近
 */
public class QuickSortFromLeft {
    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 6, 5, 4, 3, 7};
        quickSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }

    static void quickSort(int[] data, int start, int end) {
        System.out.println(start + " " + end);
        if (start == end) return;
        int index = partition(data, start, end);
        if (index > start) {
            quickSort(data, start, index - 1);
        }
        if (index < end) {
            quickSort(data, index + 1, end);
        }
    }

    // partition就是将base值两侧排序好，并返回base所在index
    static int partition(int[] data, int start, int end) {
        // 选取基准，可以头部、中间或者随机选取
        int index = (start + end) / 2; // index = random(start,end)
        swap(data, index, end); // 基准放在最后方便编程

        int small = start - 1;
        for (index = start; index < end; ++index) {
            if (data[index] < data[end]) {
                ++small;
                if (small != index) {
                    swap(data, index, small);
                }
            }
        }
        ++small;
        swap(data, small, end);
        return small;
    }

    static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}

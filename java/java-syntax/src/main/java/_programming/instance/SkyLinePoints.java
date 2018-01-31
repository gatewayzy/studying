package _programming.instance;

import java.util.*;

/**
 * skyline 求解，输出按照x坐标升序输出（只考虑第一象限的点）
 * 输入 5 1 2 9 0 5 3 4 6 7 5  （即 1,2  9,0  5,3  4,6  7,5 五组点）
 * 表示5组点，以及分别对应的x和y坐标。
 * 输出：4,6 7,5 9,0
 * 解法1：暴力破解，每个点与剩下的所有点比较，都不在其右上方则该点为skyline点（复杂度n*n，超限）
 */
public class SkyLinePoints {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = scanner.nextInt();
            data[i][1] = scanner.nextInt();
        }
        scanner.close();
        getSkyline1(data, n);
    }

    public static void getSkyline1(int[][] data, int n) {
        List<int[]> res = new ArrayList<int[]>();
        boolean flag = true;
        for (int i = 0; i < n; i++) {  // 对每个点判断是不是每个点都不在他的右上方
            flag = true;
            for (int j = 0; flag && j < n; j++) {
                if (data[j][0] > data[i][0] && data[j][1] > data[i][1]) {
                    flag = false;
                    break;
                }
                if (j == n - 1) res.add(new int[]{data[i][0], data[i][1]});
            }
        }
        // 对skyline结果按照x升序、y升序
        Collections.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) return a[0] - b[0];
                else return b[1] - a[1];
            }
        });
        // 输出结果
        for (int i = 0; i < res.size(); i++) {
            int[] arr = res.get(i);
            System.out.println(arr[0] + " " + arr[1]);
        }
    }
}
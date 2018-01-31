package _programming.instance;

import java.util.Arrays;

/**
 *
 * 对于一个长度为N的整型数组A， 数组里所有的数都是正整数，对于两个满足0<=X <= Y <N的整数，A[X], A[X+1] …
 * A[Y]构成A的一个切片，<br>
 * 记作(X, Y)。 用三个下标 m1, m2, m3下标满足条件 0 < m1, m1 + 1 < m2, m2 +1 < m3 < N – 1。<br>
 * 可以把这个整型数组分成(0, m1-1), (m1+1, m2-1), (m2+1, m3-1), (m3+1, N-1) 四个切片。<br>
 * 如果这四个切片中的整数求和相等，称作“四等分”。
 * 编写一个函数，求一个给定的整型数组是否可以四等分，如果可以，返回一个布尔类型的true，如果不可以返回一个布尔类型的false。 <br>
 * 限制条件： 数组A最多有1,000,000项，数组中的整数取值范围介于-1,000,000到1,000,000之间。<br>
 * 要求： 函数的计算复杂度为O(N)，使用的额外存储空间（除了输入的数组之外）最多为O(N)。<br>
 * 例子：<br>
 * 对于数组A=[2, 5, 1, 1, 1, 1, 4, 1, 7, 3, 7] <br>
 * 存在下标 2, 7, 9使得数组分成四个分片[2, 5], [1, 1, 1, 4], [7], [7]，<br>
 * 这三个分片内整数之和相等，所以对于这个数组，函数应该返回true。<br>
 * 对于数组 A=[10, 2, 11, 13, 1, 1, 1, 1, 1]， 找不到能把数组四等分的下标，所以函数应该返回false。
 */
public class QuartDivide {

	/**
	 * 从两边开始找，找到之后再找中间<br>
	 * 技巧，注意到只删除3个元素，又因为要第一分组与第四分组相等.<br>
	 * 设等分值为v,第一分组n1与第二分组元素n4个数共为n,则2<=N-3-n<=2v
	 */
	static boolean resolve2(int[] A) {
		if (A == null || A.length == 0) {
			return false;
		}
		int[] re = findValLocate(A);
		System.out.println("寻找完毕，开始检查: " + Arrays.toString(re));
		re[2] = checkingFind(A, re[0], re[1] + 1, re[3] - 1); // 减1是由于有4部分，最后一部分至少占用1个位置。
		System.out.println("检查: " + Arrays.toString(re));
		int v3 = checkingFind(A, re[0], re[2] + 1, re[3]);// 检查第四部分的分割点是否为re[3]
		if (v3 == re[3]) {
			return true;
		}
		return false;
	}

	static int checkingFind(int[] A, int val, int begin, int end) {
		int s = 0;
		for (int i = begin; i < end; ++i) {
			s = s + A[i];
			if (s == val) {
				// 返回要去除那个点。
				return i + 1;
			}
		}
		return -1;
	}

	/* 返回均分值，与要去除的第一个和第三个位置 */
	static int[] findValLocate(int[] A) {
		int v1 = 0, v4 = 0;
		for (int i = 0, j = A.length - 1; i < j;) {

			if (v1 < v4) {
				v1 = v1 + A[i];
				++i;
			} else if (v1 > v4) {
				v4 = v4 + A[j];
				--j;
			} else {
				/* 验证：2<=N-3-n<=2v */
				int m = A.length - 3 - (i + 1 + A.length - j);
				if (m >= 2 && m <= 2 * v1) {
					/*
					 * 这里返回的是去除点的位置，i,j没有加减， 是因为以前的操作都让它向后移了一位了， 现在指的就是要去除的点
					 */
					int re[] = { v1, i, 0, j };
					return re;
				} else {
					v1 = v1 + A[i];
					++i;
				}

			}
		}
		return null;
	}

	public static void main(String[] args) {
		/*
		 * ArrayList<Integer> inputs = new ArrayList<Integer>(); Scanner in =
		 * new Scanner(System.in); String line = in.nextLine(); while (line !=
		 * null && !line.isEmpty()) { int value = Integer.parseInt(line.trim());
		 * if (value == 0) break; inputs.add(value); line = in.nextLine(); }
		 * int[] A = new int[inputs.size()]; for (int i = 0; i < inputs.size();
		 * i++) { A[i] = inputs.get(i).intValue(); }
		 */
		// int[] A={1,1,1,1,7,1,3,4,1,2,1,5,2,2};
		// int[] A = { 1, 1, 1, 1, 10, 1, 3, 1, 1, 2, 1, 5, 2, 2 };
		int[] A = { 2, 5, 1, 1, 1, 1, 4, 1, 7, 3, 7 };
		Boolean res = resolve2(A);

		System.out.println(String.valueOf(res));
	}
}

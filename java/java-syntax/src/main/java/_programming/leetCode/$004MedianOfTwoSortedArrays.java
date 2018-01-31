package _programming.leetCode;

/*
 * 本题题意：给出两个有序数组，找到这两个数组的中位数（中位数也可能是两个数的平均值）。希望时间复杂度为log(m+n)
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * 解题思路：首先明确中位数的求法，如果有奇数个数字，那么就是中间位置的数字；如果是偶数个数字，那么就是中间两个数字的平均值。
 * 本题的思路就是通过二分法，在两个数组中找到第k大数。两个链表的时候，就是决定要从两个数组中取多少数字，如果是第k大数，希望每个数组中取出k/2个元素、
 * 如果数组本身的数字少于k/2个，那么这个就要全取，另外一个取剩下元素的多少。然后通过递归调用的方式获取就可以了。
 * */
/**
 * hard
 * 
 *
 */
public class $004MedianOfTwoSortedArrays {
	public static void main(String args[]) {
		int[] a = new int[] { 1, 2, 3 };
		int[] b = new int[] { 3, 4 };

		double ret = Solution$004MedianOfTwoSortedArrays.findMedianSortedArrays(a, b);
		System.out.println(ret);
	}

}

/*
 * 转换成查找第k个大的数字的问题，如果一共有奇数个数字就查找中间第k大的数，如果偶数个就查找中间k与k+1大的数.
 * 由于要求要log(m+n)，需要使用二分查找，只需在A中二分查找就可以确定B中相应k-位置
 */
class Solution$004MedianOfTwoSortedArrays {

	public static double findMedianSortedArrays(int nums1[], int nums2[]) {

		/***/
		int m = nums1.length;
		int n = nums2.length;
		int k = m + n;
		double ret = 0L;
		if ((k & 1) > 0) {
			ret = findKth(nums1, 0, m, nums2, 0, n, k / 2 + 1);
		} else {
			ret = (findKth(nums1, 0, m, nums2, 0, n, k / 2) + findKth(nums1, 0, m, nums2, 0, n, k / 2 + 1)) / 2;
		}

		return ret;
		/***/

	}

	public static double findKth(int A[], int pluseNuma, int m, int B[], int pluseNumb, int n, int k) {
		// 递归基础是A比B短
		if (m > n) {
			return findKth(B, pluseNumb, n, A, pluseNuma, m, k);
		}

		// 递归中A为空则返回B中偏移之后第k个数字
		if (m == 0) {
			return B[pluseNumb + k - 1];
		}

		// 递归遇到查找的k为0或1，就是A和B的开头中最小的一个
		if (k <= 1) {
			return min(A[pluseNuma], B[pluseNumb]);
		}
		// 二分查找A的k/2或m，就对应了B中对应的k-A
		// 由于保证A比B短，因此可以判定是否A最大值小于B或者A对应中值小于B对应中值
		int pa = min(k / 2, m);
		int pb = k - pa;

		// A中选取小于B中剩余的第K大的数
		if (A[pluseNuma + pa - 1] < B[pluseNumb + pb - 1]) {
			// 减小A中元素
			return findKth(A, pluseNuma + pa, m - pa, B, pluseNumb, n, k - pa);
		} else if (A[pluseNuma + pa - 1] > B[pluseNumb + pb - 1]) {
			return findKth(A, pluseNuma, m, B, pluseNumb + pb, n - pb, k - pb);
		} else {
			return A[pluseNuma + pa - 1];
		}

	}

	public static int min(int a, int b) {
		return a < b ? a : b;
	}
}

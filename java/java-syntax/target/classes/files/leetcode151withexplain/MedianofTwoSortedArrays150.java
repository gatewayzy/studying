package _programming.leetcode151withexplain;

/**
 * 本题题意：给出两个有序数组，找到这两个数组的中位数（中位数也可能是两个数的平均值）。希望时间复杂度为log(m+n)
 * 
 * 解题思路：首先明确中位数的求法，如果有奇数个数字，那么就是中间位置的数字；如果是偶数个数字，那么就是中间两个数字的平均值。
 * 本题的思路就是通过二分法，在两个数组中找到第k大数。两个链表的时候，就是决定要从两个数组中取多少数字，如果是第k大数，希望每个数组中取出k/2个元素、
 * 如果数组本身的数字少于k/2个，那么这个就要全取，另外一个取剩下元素的多少。然后通过递归调用的方式获取就可以了。
 * 
 *
 */
public class MedianofTwoSortedArrays150 {
	public static void main(String args[]) {
		int[] a = new int[] { 1, 2, 3 };
		int[] b = new int[] { 3,4 };
		
		double ret = findMedianSortedArrays(a, b);
		System.out.println(ret);
	}
	
	
	
	public static double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		int k = m + n;
		//如果是奇数  那么找到中间元素
        if ((k & 1) > 0){
            return findKth(A,0, m, B,0, n, k / 2 + 1);
        }else{
        //如果是偶数  找中间两个数的平均数
            return (findKth(A,0, m, B,0, n, k / 2) + findKth(A,0, m, B,0, n, k / 2 + 1)) / 2;
        }   
    }
	
	
	/**
	 * 从两个数组中找到第k大数
	 * @param A
	 * @param pluseNuma A数组开始遍历的基准位置
	 * @param m
	 * @param B
	 * @param pluseNumb
	 * @param n
	 * @param k
	 * @return
	 */
	public static double findKth(int A[],int pluseNuma, int m, int B[],int pluseNumb, int n, int k){
		//算法的计算基础是m <= n
        //m is equal or smaller than n
        if (m > n)
            return findKth(B,pluseNumb, n, A,pluseNuma, m, k);
        
        //如果长度为0  那么就从b中找到结果
        if (m == 0)
            return B[pluseNumb+k-1];
        
        //如果找到两个数组中的第k个元素为第1个或者0个元素  那么去两个元素的最小值就可以了
        if (k <= 1)
            return min(A[pluseNuma], B[pluseNumb]);

        //看A数组里面的数据还够不够k的一半
        int pa = min(k/2, m);
        int pb = k - pa;
        //A中小于B中的情况
        if (A[pluseNuma+pa-1] < B[pluseNumb+pb-1]){
        	//A中元素减少
            return findKth(A,pluseNuma+pa, m - pa, B,pluseNumb, n, k - pa);
        }
        else if(A[pluseNuma+pa-1] > B[pluseNumb+pb-1]){
        	//b中元素范围减少
            return findKth(A, pluseNuma,m, B,pluseNumb+pb, n - pb, k - pb);
        //正好相等的情况
        }else
            return A[pluseNuma+pa-1];
    }
	
	public static int min(int a,int b){
		if(a < b) return a;
		return b;
	}
}

package _programming.leetcode151withexplain;

/**
 * 本题题意：数组中不同的数值代表不同的颜色  需要按颜色进行排序
 * 
 * 其实就是正常的数组排序  交换排序
 *
 */
public class SortColors077 {
	public void sortColors(int[] A) {
        for(int i = 0; i < A.length; i++){
            for(int j = i+1; j < A.length; j++){
                if(A[j] < A[i]){
                    int temp = A[j];
                    A[j] = A[i];
                    A[i] = temp;
                }
            }
        }   
    }
}

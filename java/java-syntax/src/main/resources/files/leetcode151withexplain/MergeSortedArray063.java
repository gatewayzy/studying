package _programming.leetcode151withexplain;

/**
 * 本题题意：给出两个有序数组  将B中的元素合并到A中  保持有序
 * 
 * 本题解题思路：即使遍历B中的元素，然后依次插入到A中就可以。
 * 
 * 注意点：在移动元素的时候，要注意边界的变化，而且移动元素的时候别忘了特殊处理。
 */
public class MergeSortedArray063 {
	
	public void merge(int A[], int m, int B[], int n) { 
        int startPosition = 0;
        int bIndex = 0;
        while(bIndex < n){
            int bNumber = B[bIndex];
            int i;
            for(i = startPosition; i < m; i++){
                
                //judge the first element whether > bNumber
                if(A[i] > bNumber){
                    int j = m;
                    for(; j > i;j--){
                        A[j] = A[j-1];
                    }
                    A[i] = bNumber;
                    m++;
                    break; 
                }
                
            }
            
            //deal with special situation 属于特殊处理
            if(i == m){
                A[m] = bNumber;
                m++;
            }
            
            //下一个开始位置就可以不从0开始了
            startPosition = i+1;
            bIndex++;
        }
     }
}

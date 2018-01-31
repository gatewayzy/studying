package _programming.leetcode151withexplain;

/**
 * 本题题意：给出一个数组  去除数组中重复的数字  重复数字只保留一个  返回最终数组的长度
 * 
 *  For example,
	Given input array A = [1,1,2],
	
	Your function should return length = 2, and A is now [1,2].
 *
 * 	解题思路：遍历这个数组，重复的我就可以不要，然后把不重复的就复制到前面，然后就可以知道有多少个元素。
 *
 */
public class RemoveDuplicatesfromSortedArray126 {
	
 	public int removeDuplicates(int[] A) {
        
 		//长度
        int Alength = A.length;
        //特殊情况处理
        if(Alength == 0){
            return 0;
        }
        
        if(Alength == 1){
            return 1;
        }
        
        //记录结果的大小和前面可以插入的位置
        int resultSize = 1;
        int prePosition = 1;
        //从第二个元素开始遍历  如果与自己前面的元素相等，那么就跳过，如果不相等，那么就赋值给前面的位置
        for(int i = 1; i < Alength; i++){
            if(A[i] != A[i-1]){
              resultSize++;
              A[prePosition] = A[i];
              prePosition++;
            }
            
        }
        return resultSize;
    }
}

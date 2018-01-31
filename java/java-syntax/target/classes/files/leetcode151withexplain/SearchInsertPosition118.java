package _programming.leetcode151withexplain;

/**
 * 本题题意：给出一个数组和目标值  如果数组中目标值已经存在  那么返回下标值  如果不存在，那么就返回应该插入的位置
 *  Here are few examples.
	[1,3,5,6], 5 → 2
	[1,3,5,6], 2 → 1
	[1,3,5,6], 7 → 4
	[1,3,5,6], 0 → 0
 *
 *	本题思路：从前往后遍历  找到位置  最后别忘了处理特殊情况
 */
public class SearchInsertPosition118 {
	
 	public int searchInsert(int[] A, int target) {
        if(A.length == 0){
            return 0;
        }
        int position = 0;
        //从前往后遍历   找到位置
        for(int i = 0; i < A.length; i++){
            if(A[i] == target){
                return i;
            }else if(A[i] < target){
               position++;
            }else if(A[i] >= target){
                return position;
            }
            
        }
        //别忘了特殊处理
        if(position == A.length){
            return position;
        }
        return 0;
    }
}

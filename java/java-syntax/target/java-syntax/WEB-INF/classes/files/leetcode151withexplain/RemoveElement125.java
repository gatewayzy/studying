package _programming.leetcode151withexplain;

/**
 * 本题题意：给出一个数组，去除指定的某个元素，返回新数组的长度
 * 
 * 解题思路：遍历数组，对于相等的元素和数组的最后元素交换，返回新数组的大小。
 *
 */
public class RemoveElement125 {
	
	public int removeElement(int[] A, int elem) {
        
        int aLength = A.length-1;
        int resultSize = 0;
        
        //遍历每一个元素，如果当前元素等于elem
        for(int i = 0; i <= aLength; i++){
        	//和最后一个元素交换  
            if(A[i] == elem){
                int temp = A[aLength];
                A[aLength] = A[i];
                A[i] = temp;
                aLength--;
                i--;
            }else{
                resultSize++;
            }
        }
        
        return resultSize;
        
    }
}

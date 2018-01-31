package _programming.leetcode151withexplain;

/**
 * 本题题意：给出一个有序数组，数组中没有重复，在某一位置进行了反转，在反转后的数组中判断是否存在target数据 
 *
 *	Suppose a sorted array is rotated at some pivot unknown to you beforehand.

	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	
	You are given a target value to search. If found in the array return its index, otherwise return -1.
	
	本题解题思路：递归调用  其实和二分思想也差不多  只是分开的数组分为两种：一种就是按序排列的，那么就按二分查找法使用；一种是和原来数组构造差不多，那么就二分后，递归调用判断函数。
 */
public class SearchinRotatedSortedArray071 {
	
   public int search(int[] A, int target) {
        if(A.length == 0){
            return -1;
        }else if(A.length == 1 && A[0] == target){
            return 0;
        }
        
        return searchPosition(A, target,0,A.length-1);
  }
  
  public int searchPosition(int[] A, int target,int startPosition, int endPosition){
      if(startPosition > endPosition){
         return -1;              
      }
      
      int result = -1;
      
      int left = startPosition;
      int right = endPosition;
      //如果在一个有序范围内
      if(A[left] <= A[right]){
          
    	  //那么就按照二分查找发查找
          while(left <= right && A[left] <= A[right]){
              int mid = (left+right) >> 1;
              if(A[mid] == target){
                  return mid;
              }
              
              if(A[mid] > target){
                  right = mid - 1;
              }else{
                  left = mid + 1;
              }
          }
      }else{
          
    	  //中间位置判断
          int mid = (startPosition+endPosition) >> 1;
          if(A[mid] ==  target){
              return mid;
          }
          
          //递归调用：判断左半部分和右半部分
          result = searchPosition(A, target,startPosition,mid-1);
          if(result != -1){
              return result;
          }else{
              result = searchPosition(A, target,mid+1,endPosition);
          }
          
          
      }
      return result;
  }
}

package _programming.leetcode151withexplain;

/**
 * 本题题意：给出一个有序的数组和一个目标值，找到该数组中该目标值出现的范围
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
   return [3, 4].
 *
 *	解题思路：采用二分查找的方式，如果中间位置等于目标值，那么从左右两边找到范围，如果大于，那么就是左边部分递归调用，如果小于，那么就是右边部分。
 */
public class SearchforaRange119 {
	
	public int[] searchRange(int[] A, int target) {
        return searchRangeDetail(A, 0, A.length-1,target);
    }
    
	/**
	 * 返回范围
	 * @param A 给定的数组
	 * @param startPosition 数组的开始位置 
	 * @param endPosition 数组的结束位置
	 * @param target 目标值
	 * @return
	 */
    public int[] searchRangeDetail(int[] A, int startPosition, int endPosition, int target){
        int[] result = new int[2];
        
        //如果开始位置大于结束位置  那么就是没有找到
        if(startPosition > endPosition){
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        
        //如果开始位置和结束位置一致   而且开始和结束相等
        if(startPosition == endPosition){
            if(A[startPosition] == target){
                result[0] = startPosition;
                result[1] = endPosition;
            }else{
                result[0] = -1;
                result[1] = -1;
            }
            return result;
        }
        
        //找到中间位置
        int midPosition = (startPosition + endPosition) >> 1;
        //等于目标值的时候，那么就找左右的部分  然后合并结果就可以了
        if(A[midPosition] == target){
        	//分别找到左边的范围和右边的范围
            int[] leftR = searchRangeDetail(A, startPosition, midPosition,target);
            int[] rightR = searchRangeDetail(A, midPosition+1, endPosition,target);
            //如果两者都是-1
            if(leftR[0] == -1 && rightR[0] == -1){
                return leftR;
            }
            //左边没找到，右边找到了
            if(leftR[0] == -1 && rightR[0] != -1){
                return rightR;
            }
            
            //左边找到了，右边没有找到
            if(leftR[0] != -1 && rightR[0] == -1){
                return leftR;
            }
            
            //都找到了
            if(leftR[0] != -1 && rightR[0] != -1){
                if(leftR[0] > rightR[0]){
                    leftR[0] = rightR[0];
                }
                
                if(leftR[1] < rightR[1]){
                    leftR[1] = rightR[1];
                }
                
                return leftR;
            }
            
        }
        
        
        //如果中间值超过目标值
        if(A[midPosition] > target){
            return searchRangeDetail(A, startPosition, midPosition,target);
        }
        
        //如果中间值小于目标值
        if(A[midPosition] < target){
            return searchRangeDetail(A, midPosition+1, endPosition,target);
        }
        
        return result;
    }
}

package _programming.leetcode151withexplain;

/**
 * 本题题意：给出一组数字，代表一组bar的高度，因为参差不齐，所以很多地方可以存住水，问能够存住多少水。
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
	
	For example, 
	Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
	
	https://oj.leetcode.com/problems/trapping-rain-water/
	
	一般思路：找到每一个位置左右两边比自己高的最小值，然后就可以知道当前位置可以存住多少水。
	
	本题思路：通过两次遍历，就可以找到每一个位置前后出现的最大的bar，然后计算出每一个位置的存水量就可以了。
 * 
 *
 */
public class TrappingRainWater111 {
	
 	public int trap(int[] A) {
        int result = 0;
        //特殊情况处理
        int aLength = A.length;
        if(aLength == 1 || aLength == 0){
        	return result;
        }
        
        
        int[] leftHeight = new int[aLength];
        int[] rightHeight = new int[aLength];
        
        //从左往右扫描，记录住之前出现的最大的bar
        int maxHeight = 0;
        for(int i = 0; i < aLength; i++){
            if(A[i] > maxHeight){
                maxHeight = A[i];
            }
            leftHeight[i] = maxHeight;
        }
        
        //从右往左扫描，记录住之前出现的最大的bar
        maxHeight = 0;
        for(int j = 0; j < aLength; j++){
            if(A[aLength - 1 - j] > maxHeight){
                maxHeight = A[aLength - 1 - j];
            }
            rightHeight[aLength - 1 - j] = maxHeight;
        }
        
        //然后计算出每一个位置可以存储的水量就可以了
        int temp = 0;
        for(int k = 0; k < aLength; k++){
            temp = minNum(leftHeight[k],rightHeight[k]) - A[k];
            //必须保证大于0
            if(temp > 0){
                result += temp;
            }
        }
       
        return result;
    }
    
    public int minNum(int a, int b){
        if(a < b){
            return a;
        }else{
            return b;
        }
    }
}

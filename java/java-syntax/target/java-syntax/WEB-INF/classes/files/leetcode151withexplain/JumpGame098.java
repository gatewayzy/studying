package _programming.leetcode151withexplain;

/**
 *  本题题意：给出一个数组，数组中的数字代表其在位置上可以往后跳的最长距离，问能否跳到最后的地方。
 *  
 *  For example:
	A = [2,3,1,1,4], return true.
	A = [3,2,1,0,4], return false.
 *
 *	解题思路：通过找到每一个位置能够延伸到的最远地方，最后判断能否到最后的位置就可以了
 */
public class JumpGame098 {
	
	public boolean canJump(int[] A) {
        int aLength = A.length;
        //初始化maxTouch，用于记录现在最远能够到达的地方
        int maxTouch = A[0];
        //特殊情况  当就一个元素  而且长度大于1的时候
        if(maxTouch == 0 && A.length != 1) return false;
        
        //从开始位置遍历，知道最大tempTouch
        for(int i = 0; i <= maxTouch && i < aLength; i++){
            int tempTouch  = i + A[i];
            if(maxTouch < tempTouch){
                maxTouch = tempTouch;
            }
        }
        
        //判断maxTouch，如果可以达到最后位置，就返回true
        if(maxTouch >= (aLength-1)){
            return true;
        }else{
            return false;
        }
    }
}

package _programming.leetcode151withexplain;

/**
 * 本题题意：给出一个数组，每一位上面的元素代表当前元素可以往前跳的步数。问最少多少部能够到最后的元素。
 * 
 * 解题思路：通过start和end标识一个区间的开始和结束，代表当前可以起跳的范围。然后找到由该区间可以跳到的最远位置。这样循环便可以找到一个新的区间，end+1到刚才求的最大的可达位置。
 * 没求的一个空间，那么k++,代表区间之间的跳跃。最后可以达到就行了。
 * 
 * 注意点：如果跳不下去的时候，返回-1
 */
public class JumpGameII108 {
	
	public int jump(int[] A) {
        int n = A.length;
        int  k = 0;  
        int start = 0;  
        int end = 0;
        //当end尚未到达最后的时候
        while(end < n-1)  
        {   
        	
            int newEnd = Integer.MIN_VALUE;
            //遍历现在可遍历的节点   找到最大可以覆盖到的地方
            for(int i = start; i <= end; ++i)  
                newEnd = max(newEnd, A[i]+i);
            
            //如果无法往前跳
            if(newEnd == end) return -1;
            
            start = end+1;  
            end = newEnd;  
            ++k;  
        }  
        return k;  
    }
    
    public int max(int a, int b){
        if(a > b){
            return a;
        }else{
            return b;
        }
    }
}

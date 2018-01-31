package _programming.leetcode151withexplain;

/**
 * 本题题意：给出一个数组，数字最多出现两次，去重，然后返回结果数组的大小
 * 
 *  For example,
	Given sorted array A = [1,1,1,2,2,3],

	Your function should return length = 5, and A is now [1,1,2,2,3].
	
	
 *
 */
public class RemoveDuplicatesfromSortedArrayII072 {
	
	public int removeDuplicates(int[] A) {
        int n = A.length;
        if(n == 0) return n;
        
        //用于记录前面的数字
        int prevNum = A[0];
        //用于记录和前面数字相同的数字有几个
        int prevCnt = 1;
        //记录当前下标
        int curIdx = 1;
        //循环遍历数组中的每一个元素
        for(int i = 1; i < n; ++i)  
        {  
        	//如果现在的元素和前面的元素相等
            if(A[i] == prevNum)  
            {  
            	//特殊情况处理   已经出现了两个的时候
                if(prevCnt == 2) continue;  
                else{ 
                	//还尚未出现两个
                    A[curIdx++] = A[i];
                    prevCnt++;
                }
            }
            //如果不相等 
            else  
            {  
                A[curIdx++] = A[i];  
                prevNum = A[i];  
                prevCnt = 1;  
            }  
        }  
        return curIdx;  
        
    }
}

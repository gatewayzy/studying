package _programming.leetcode151withexplain;

import java.util.Arrays;

/**
 * 本题题意：给出一个排列，返回下一个排列。
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
	1,2,3 → 1,3,2
	3,2,1 → 1,2,3
	1,1,5 → 1,5,1
 *
 *	解题思路：从后往前遍历，看是否存在有前面的数字小于后面数字的情况，找到这个小于的位置；然后找到小于的这个位置后面的最小的大于它的数值，交换两个位置；然后对后面的元素排序。
 */
public class NextPermutation121 {
	
	public void nextPermutation(int[] num) {
        if(num.length == 0) return;
        
        int maxReverse = num[num.length - 1];  
        int index = -1;
        //从后面开始遍历，看能否找到后面的数字找到比前面大的数字
        for(int i = num.length - 2; i >= 0; --i)   
        {  
        	//如果后面找到了比前面大的数字
            if(maxReverse > num[i])  
            {  
            	//记录住现在的这个比较小的数的位置
                index = i;  
                break;  
            }  
            else maxReverse =  num[i];  
        }  
        //not found
        //即没有找到后面的数字比前面大的情况，那么就排序返回就可以了
        if(index == -1)  
        {  
            Arrays.sort(num);  
            return;  
        }  
        else  
        {  
             //find the minimum bigger element  
            int minNum = num[index+1];  
            int minIdx = index+1;  
            for(int i = index+1; i < num.length; ++i)  
            {  
                if(num[i] > num[index] && num[i] < minNum)  
                {  
                    minNum = num[i];  
                    minIdx = i;  
                }  
            }  
            
            int temp = num[index];
            num[index] = num[minIdx];
            num[minIdx] = temp;
              
            sort(num,index+1);  
        }   
    }
    
	//从数组指定位置开始排序
    public void sort(int[] num, int startPosition){
        for(int i = startPosition; i < num.length; i++){
            for(int j = startPosition; j < num.length-1; j++){
                if(num[j] > num[j+1]){
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                }
            }
        }
    }
}

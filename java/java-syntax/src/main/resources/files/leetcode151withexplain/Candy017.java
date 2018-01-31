package _programming.leetcode151withexplain;

/**
 * 本题题意就是有一群孩子，每个孩子有个评分，每个孩子至少分到一块糖，分数高的孩子要比分数低的孩子糖要多，问最少分多少糖。 
 *
 * 本题解题思路：
 * 用两个数组，一个从左向右遍历，如果后面的孩子比前面紧挨着的孩子分数高，那么分到的糖就++；如果后面孩子的分数比紧挨着孩子的分数低或者等于，那么分到的糖就变为1；
 * 
 * 然后同时遍历两个数组，求出结果就可以了。
 */
public class Candy017 {
	
	public int candy(int[] ratings) {
        int length = ratings.length;
        int[] lefttoright = new int[length];
        int[] righttoleft = new int[length];
        
        //从左到有遍历  设置糖果分配值
        for(int i = 0; i < length; i++){
            if(i == 0){
                lefttoright[i] = 1;
            }else{
                if(ratings[i] > ratings[i-1]){
                    lefttoright[i] = lefttoright[i-1]+1;
                //这个比较特殊  如果小于等于的时候  直接设置为1
                }else if(ratings[i] <= ratings[i-1]){
                    lefttoright[i] = 1;
                }
            }
        }
        
        for(int j = length-1; j >= 0; j--){
            if(j == (length-1)){
                righttoleft[j] = 1;
            }else{
                if(ratings[j] > ratings[j+1]){
                    righttoleft[j] = righttoleft[j+1]+1;
                }else if(ratings[j] <= ratings[j+1]){
                    righttoleft[j] = 1;
                }
            }
        }
        
        int result = 0;
        for(int k = 0; k < length; k++){
            result += max(lefttoright[k],righttoleft[k]); 
        }
        
        return result;
        
    }
    
    public int max(int a, int b){
        if(a > b){
            return a;
        }else{
            return b;
        }
    }
}

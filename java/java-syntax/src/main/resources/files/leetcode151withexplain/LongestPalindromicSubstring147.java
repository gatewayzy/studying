package _programming.leetcode151withexplain;

/**
 * 本题题意：求出给定字符串里面的最长回文子串
 * 
 * 解题思路：首先初始化，都是一个元素的时候，那么就是回文，然后再两个两个字符的判断，然后三个三个的判断，其实就和矩阵向右上角移动的感觉是一样的。
 * 
 * 然后通过一个范围变量记录住答案的范围。返回结果就行了。
 *
 */
public class LongestPalindromicSubstring147 {
	
	
	//通过dp的方式获取
	boolean[][] dp;  
    
    public String longestPalindrome(String s){
    	
    	//特殊情况处理  如果长度为0或者1  那么直接返回就可以了
        if(s.length() == 0)  
        {  
            return "";  
        }  
        if(s.length() == 1)  
        {  
            return s;  
        }  
  
        dp = new boolean[s.length()][s.length()];  
          
        int i,j;  
         
        //初始化，把矩阵的左下角都声明为True
        for( i = 0; i < s.length(); i++)  
        {  
            for( j = 0; j < s.length(); j++)  
            {  
                if(i >= j)  
                {  
                    dp[i][j] = true;  
  
                }  
                else  
                {  
                    dp[i][j] = false;
                }  
            }  
        }  
         
        
        int k;  
        int maxLen = 1;
        //记录住边界
        int rf = 0, rt = 0;
        //遍历方式是矩阵的左上角斜着往右下角遍历   所以外层循环是1到s.length
        for( k = 1; k < s.length(); k++)  
        {  
        	//内层是从0开始遍历到最下面一行  但是遍历的范围是变小的  所以条件是k+i < s.length
        	//i代表字符串的开始位置  j代表元素的结束位置
            for( i = 0;  k + i < s.length(); i++)  
            {  
                j = i + k;  
                if(s.charAt(i) != s.charAt(j))  
                {  
                    dp[i][j] = false;  
                }  
                else 
                {  
                    dp[i][j] = dp[i+1][j-1];  
                    if(dp[i][j])  
                    {  
                        if(k + 1 > maxLen)  
                        {  
                            maxLen = k + 1;  
                            rf = i;  
                            rt = j;  
                        }  
                    }  
                }  
            }  
        }  
        return s.substring(rf, rt+1);  
    }
}

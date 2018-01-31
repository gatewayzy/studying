package _programming.leetcode151withexplain;

/**
 * 本题题意：给出一个整数  判断这个整数是不是回文格式的
 * 
 * 解题思路：首先获取输入的数字一共有多少位，10000000.然后不断的遍历获取数字的前后两个数字，前面的数字求商，后面的数字求余数。然后取出最左边和最右边的元素，左边靠减法，右边靠除法。
 * 然后就可以知道是否是回文的了。
 * 
 *  
 */
public class PalindromeNumber143 {
	
	public boolean isPalindrome(int x) {
        
        if(x < 0){
            return false;
        }
        
        if(x == 0){
            return true;
        }
    
        //base就能知道一共有多少位【数字可以到多少位】
        int base = 1;
        while(x/base >= 10){
            base *= 10;
        }
        
        //循环遍历
        while(x > 0){
        	//求出最高位
            int leftval = x/base;
            //求的最低位
            int rightval = x%10;
            //不相等就返回false
            if(leftval != rightval){
                return false;
            }
            
            //去掉左边的数值
            x = x - leftval*base;
            //少了两位  那么就要除以100
            base = base/100;
            //去掉右边的数值
            x = x/10;
        }
        
        return true;
        
    }
}

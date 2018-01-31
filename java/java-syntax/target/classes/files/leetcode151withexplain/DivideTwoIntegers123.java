package _programming.leetcode151withexplain;

/**
 * 本题题意：给出两个整数  求出结果  不能用已有的乘法   出发和求余函数
 * 
 *
 */
public class DivideTwoIntegers123 {
	
	public int divide(int dividend, int divisor) {
        long a = (long)Math.abs((long)dividend);  
        long b = (long)Math.abs((long)divisor);  
        long res = 0;
        
        while(a >= b)  
        {  
            long c = b;
            //through << to accelate the caluation
            //c每一轮左移一位 就代表乘以2,那么这里面就包含了1<<i个b
            for(int i = 0; a >= c; i++, c <<=1)  
            {  
                a -= c;  
                res += 1<<i;  
            }  
        } 
        
        //决定正负号
        boolean positiveOrNot = true;
        if(dividend > 0 && divisor < 0) positiveOrNot = false;
        if(dividend < 0 && divisor > 0) positiveOrNot = false;
        
        return positiveOrNot == true ? (int)(res) : (int)(-res);  
    }
}

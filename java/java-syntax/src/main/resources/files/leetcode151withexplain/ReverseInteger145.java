package _programming.leetcode151withexplain;

/**
 * 本题题意：给出一个整数，反转这个整数
 * 
 *  Example1: x = 123, return 321
	Example2: x = -123, return -321
 * 
 * 	解题思路：通过取余数就能知道最后的数字是什么，然后依次乘以10加刚获取的末尾元素。然后别忘了最后情况的处理。
 *
 */
public class ReverseInteger145 {
	
   	public int reverse(int x) {
   		//如果介于0-10之间或者0--10之间  单位数 直接返回
        if(x > 0 && (x/10) < 1){
            return x;
        }else if(x < 0 && (x/10) > -1){
        	return x;
        }
        
        //处理整数比较方便   所以用y来存储
        int y = 0;
        if(x > 0){
        	y = x;
        }else{
        	y = -x;
        }
        
        //获取最后一位  然后依次加上
        int result = 0;
        while(y / 10 >= 1){
            int lastNum = y % 10;
            result = result*10 + lastNum;
            y = y/10;
        }
        
        //别忘了最后剩余数据的处理
        result = result*10 + y;
        
        if(x > 0){
            return result;
        }else{
            return 0-result;
        }
    }
}

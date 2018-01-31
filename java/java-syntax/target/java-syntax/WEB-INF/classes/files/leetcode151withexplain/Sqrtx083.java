package _programming.leetcode151withexplain;

/**
 *  本题题意：求平方根
 *  Implement int sqrt(int x) 
 *  
 *  解题思路：采用二分查找的方法找到这个数值就可以了
 *
 */
public class Sqrtx083 {
	
	public int sqrt(int x) {
         if(x < 0) return 0;
	     if(x == 0) return 0;
	     if(x == 1) return 1;
	     //用长整形来做这件事情  非常的重要  放置越界
	     long  result = 0;
	     long  left = 0;
	     long   right = x;
	     //采用二分的方法找到所需的元素
	     while(left < right){
	    	 //从中间元素开始
	         long middle = left  + ((right-left) >> 1);
	         long tempresult = middle*middle;
	         if(tempresult == x){
	             return (int)middle;
	         }
	         
	         //一下比较特殊  因为有些时候可能不会严格相等  但是这个时候无法再分  那么就选择left或者right里面的数值
	         if(tempresult > x && middle != right){
	             right = middle;  
	         }else if(tempresult < x && middle != left){
	             left = middle;
	         }else{
	             result = middle == left? left:right;
	             break;
	         }
	         
	     }
	     return (int)result;
   }
}

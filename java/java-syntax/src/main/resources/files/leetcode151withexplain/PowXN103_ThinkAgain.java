package _programming.leetcode151withexplain;

/**
 * 本题题意：幂函数  X的N次幂函数
 *
 *  解题思路：首先可以通过递归调用的方式调用该函数。要考虑n的各种情况，n等于0的时候，那么结果就是1；如果n<0的时候，那么就要反转一下，小于0的时候，还存在等于integer最小值的情况。
 *  然后在计算的过程中可以跳跃计算。
 *  
 *  
 */
public class PowXN103_ThinkAgain {
	
	public static void main(String[] args){
		PowXN103_ThinkAgain object = new PowXN103_ThinkAgain();
		object.pow(2.0, 15);
	}
	
	public double pow(double x, int n) {
        //n小于零的时候
		if(n<0){  
			//如果n是整数的最小值
			//2147483647
			//-2147483648
			//最小值的绝对值比最大值的绝对值大1
            if(n == Integer.MIN_VALUE)  
                return 1.0 / (pow(x,Integer.MAX_VALUE)*x);  
            else  
                return 1.0 / pow(x,-n);  
        }
        
        //边界条件
        if(n==0)  
            return 1.0;  
        
        //ans用于记录结果
        double ans = 1.0 ;  
        
        
        //每次都是x的2次方   循环到i次，那么x就等于x的2^i次方。 所以n便可以不断的除以2
        for(;n>0; x *= x, n>>=1)  
        {  
        	//判断n是奇数还是偶数
            if((n & 1) > 0)  
                ans *= x;  
        }  
        return ans;  
    }
	
	//这种方式会出现stackover  通过递归调用的方式获取
	public double pow1(double x, int n) {
		//边界条件判断
        if(n == 0){
            return 1.0;
        }
        
        //如果小于0，那么就应该这样处理
        if(n < 0){
            return 1.0/pow1(x,-n);
        }
        
        //获取一般的power
        double half = pow1(x,(n >> 1));
        
        //如果是偶数  那么就是half*half
        if(n % 2 == 0){
            return half * half;
        //如果不是0  那么就是half*half*x
        }else{
            return half * half * x;
        }
    }
}

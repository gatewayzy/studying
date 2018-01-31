package _programming.leetcode151withexplain;

import java.util.ArrayList;

/**
 *	本题题意：给出两个数字n和k,将1-n里面的数字进行排列，一共有n!种，求排列中的第k个。
 *
 * We get the following sequence (ie, for n = 3):
	"123"
	"132"
	"213"
	"231"
	"312"
	"321"
	Given n and k, return the kth permutation sequence.
 *	
 *	本题思路：就是找到了规律，每一个数作为开头的可能只有（n-1）!种，而且第一个数的出现是循环出现
 */
public class PermutationSequence093 {
	
	public String getPermutation(int n, int k) {
        if(n < 0) return null;
        if(n == 0) return "";
        
        //用nlist来存储每一个数字  方便后续的数值的获取
        ArrayList<Integer> nlist = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            nlist.add(i+1);
        }
        
        return getAnswer(nlist,n,k-1);
    }
    
	/**
	 * 
	 * @param nlist
	 * @param n 代表当前有几个数
	 * @param k  第几个
	 * @return
	 */
    public String getAnswer(ArrayList<Integer> nlist, int n, int k){
        String result = "";
        //边界条件  就是只有一个元素的时候 
        if(n == 1){
            result += nlist.get(0);
            nlist.remove(0);
            return result;
        }
        
        //获取n-1的阶乘
        int nFactorial = getFactorial(n-1);
        //计算当求第k个的时候，应该是第几个数字
        int i = k/nFactorial;
        result += nlist.get(i);
        nlist.remove(i);

        //递归调用  后面的第k个元素要变换  因为前面已经去掉了一部分  所以就是找k-i*nFactorial个元素
        return result+getAnswer(nlist,n-1,k-i*nFactorial);
    }
    
    //获取n的阶乘
    public int getFactorial(int n){
        if(n == 0) return 1;
        int nFactorial = 1;
        for(int i = 1; i <= n; i++){
            nFactorial *= i;
        }
        return nFactorial;
    }
}

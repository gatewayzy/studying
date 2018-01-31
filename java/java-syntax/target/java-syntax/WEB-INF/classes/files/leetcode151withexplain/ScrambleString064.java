package _programming.leetcode151withexplain;

import java.util.Arrays;

/**
 *  本题题意：给出一个字符串   那么该字符串可以通过一个树来表示   而且左右子树都可以递归的用树来表示  然后可以交换树中的左右孩子  那么就可以变成另外一个字符串
 *  现在给出两个字符串，判断S2是否就是可以通过S1变换所得。
 *  
 *  http://www.blogjava.net/sandy/archive/2013/05/22/399605.html
 *
 */
public class ScrambleString064 {
	
	//首先通过递归的方式实现
	public boolean isScramble(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        
        //边界条件处理
        if(l1!=l2){
            return false;
        }
        if(l1==0){
            return true;
        }
        
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        if(l1==1){
            return c1[0]==c2[0];
        }
        
        //如果可以转换  那么至少两个字符串所包含的字母是一样的
        Arrays.sort(c1);
        Arrays.sort(c2);
        for(int i=0;i<l1;++i){
            if(c1[i]!=c2[i]){
                return false;
            }
        }
        
        //每一层都循环遍历   比较前面的是否相等  以及比较前面和后面的是否可以互相转换
        boolean result = false;
        //注意条件  感觉特别的别致
        for(int i=1;i<l1 && !result;++i){
            String s11 = s1.substring(0,i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0,i);
            String s22 = s2.substring(i);
            result = isScramble(s11,s21) && isScramble(s12,s22);
            if(!result){
                String s31 = s2.substring(0,l1-i);
                String s32 = s2.substring(l1-i);
                result = isScramble(s11,s32) && isScramble(s12,s31);
            }
        }
        
        return result;
    }
	
	/**
	 * 采用dp的思想
	 * 声明了一个三维的数组   第一维度表示字符串的长度   第二个维度和第三个维度表示从两个字符串开始的位置。
	 * 
	 * 这里我使用了一个三维数组boolean result[len][len][len],其中第一维为子串的长度，第二维为s1的起始索引，第三维为s2的起始索引。
		result[k][i][j]表示s1[i...i+k]是否可以由s2[j...j+k]变化得来。
	 */
	public boolean isScrambledp(String s1, String s2){
        int len = s1.length();
        
        //边界条件处理
        if(len!=s2.length()){
            return false;
        }
        if(len==0){
            return true;
        }
        
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        //初始化三维数组
        boolean[][][] result = new boolean[len][len][len];
        for(int i=0;i<len;++i){
            for(int j=0;j<len;++j){
                result[0][i][j] = (c1[i]==c2[j]);
            }
        }
        
        //三层循环  因为长度为1的已经初始化了  从长度为2的开始遍历
        for(int k=2;k<=len;++k){
        	//两层循环，开始位置都是len-k
            for(int i=len-k;i>=0;--i){
              for(int j=len-k;j>=0;--j){
            	  //里面这个其实就是将字符串分为两端，前面的比较，和后面的比较，前面和后面的比较
                  boolean r = false;
                  for(int m=1;m<k && !r;++m){
                      r = (result[m-1][i][j] && result[k-m-1][i+m][j+m]) || (result[m-1][i][j+k-m] && result[k-m-1][i+m][j]);
                  }
                  result[k-1][i][j] = r;
              }
            }
        }
        
        return result[len-1][0][0];
    }
}

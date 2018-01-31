package _programming.leetcode151withexplain;

/**
 * 本题题意：通配符匹配   字符串中有？和*,判断两个字符串是否相等
 * 
 *  '?' Matches any single character.
	'*' Matches any sequence of characters (including the empty sequence).
 *	Some examples:
	isMatch("aa","a") → false
	isMatch("aa","aa") → true
	isMatch("aaa","aa") → false
	isMatch("aa", "*") → true
	isMatch("aa", "a*") → true
	isMatch("ab", "?*") → true
	isMatch("aab", "c*a*b") → false
	
	解题思路：通过动态规划的方式来判断；
	当p中的字符是*的时候， d[i][j] = dp[i-1][j] || dp[i][j-1]
	当p中的字符是？的时候或者两个字符串的字符相等的时候，  d[i][j] = dp[i-1][j-1]
	别忘了初始化条件，当s为空的时候，p里面全是*才可以
 */
public class WildcardMatching109 {
	
	public static void main(String[] args){
		WildcardMatching109 object = new WildcardMatching109();
		object.isMatch("rabbit", "ra?b*");
	}
	
	public boolean isMatch(String s, String p){
        int len_s = s.length();  
        int len_p = p.length();  
  
        //if the characters not equals * is more than s.length it will be wrong
        int pPosition = 0;
        int cnt = 0;
        //找出p中的非*的数目，如果已经多余s的长度，那么就错了。
        while (pPosition < len_p){
            if (p.charAt(pPosition++) != '*'){
                cnt++;
            }
        }
        if (cnt > len_s) return false;  
          
          
        boolean[][] dp = new boolean[len_s+1][len_p+1];  
  
        dp[0][0] = true;  
        for (int i = 1; i <= len_p; i++) {  
            //deal with the first row: if the pre several chars is * in p
        	//初始化第一行数据  这个其实就是判断是不是前面一直是*,即当s为空的时候，p如何匹配的
            if (dp[0][i-1] && p.charAt(i-1) == '*') dp[0][i] = true;  
            
            for (int j = 1; j <= len_s; ++j)  
            {  
            	//如果现在p为* 那么可以考察去掉*的时候前后是否相等  以及考虑不加*的时候是否一样的
                if (p.charAt(i-1) == '*') dp[j][i] = (dp[j-1][i] || dp[j][i-1]);
                //如果是？号  或者  现在两个字符串的字符相等  那么结果就取决于两个字符串前面的部分
                else if (p.charAt(i-1) == '?' || p.charAt(i-1) == s.charAt(j-1)) dp[j][i] = dp[j-1][i-1];  
                else dp[j][i] = false;  
            }  
        }  
        return dp[len_s][len_p];  
    }
}

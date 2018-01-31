package _programming.leetcode151withexplain;

/**
 * 本题题意：常规字符串匹配   .代表任意一个字符，*代表前面的元素重复0次或者其他次数
 * 
 *  Some examples:
	isMatch("aa","a") → false
	isMatch("aa","aa") → true
	isMatch("aaa","aa") → false
	isMatch("aa", "a*") → true
	isMatch("aa", ".*") → true
	isMatch("ab", ".*") → true
	isMatch("aab", "c*a*b") → true
 * 
 *  解题思路：采用递归调用的思想；遍历p，先看看第二个字符是不是*，如果不是*的话，那么就一定要判断前面的第一个字符是不是可以匹配的，如果前面字符匹配了，那么就看看那后面的字符串是不是匹配的；
 *  如果是*,那么就要判断*号代表前面的字符出现几次。如果前面的不断匹配，那么就要继续往后遍历s，当前面不匹配的时候，那么就要看看两个字符串后面的部分是不是匹配。
 *
 */
public class RegularExpressionMatching142 {
	
	public boolean isMatch(String s, String p) {
        // if pattern is empty - whole string should be empty to match
		//特殊情况处理
        if (p.length() == 0) return s.length() == 0;
    
        // retrieve 2nd character of the pattern
        //获取p里面的第二个字符
        String nextChar = (p.length() > 1) ? String.valueOf(p.charAt(1)) : "";
        //获取首字符
        char tfirst = (s.length() > 0) ? s.charAt(0) : 0;
        char pfirst = p.charAt(0);
    
        // if 2nd char is not '*' - it means that we are checking if next char in text matches with next char in pattern
        // and recursively run the code starting from +1 char in both pattern/text
        //如果第二个字符不是*  那么就要判断前面的部分是否是匹配的
        if (!"*".equals(nextChar)) {
        	//关系设置
            return ((tfirst == pfirst) || (pfirst == '.' && tfirst != 0)) && isMatch(s.substring(1), p.substring(1));
        }else{
        	//如果第二个是*  那么就要看
            while ((tfirst == pfirst) || (pfirst == '.' && tfirst != 0)) {
                // check if current text matches tail part of the pattern (+2 symbols)
            	//遍历不考虑前两个字符串的时候，也就是*的作用是前面的字符出现0次的时候
                if (isMatch(s, p.substring(2))) return true;
                // cut first symbol in original text and repeat the check in the loop
                s = s.substring(1);
                tfirst = (s.length() > 0) ? s.charAt(0) : 0;
            }
            //说明前面的字符不相等，那么要强制*的作用就是0次出现
            return isMatch(s, p.substring(2));
        }

    }
}

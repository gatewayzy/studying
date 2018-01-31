package _programming.leetcode151withexplain;

/**
 * 本题题意：实现字符串查找。给出字符串haystack和needle，判断needle在haystack第一次出现的位置，返回i之后的所有字符串。
 * 
 * 解题思路：遍历每一个haystack的每一个位置【至少不能是后面的字符串】，然后看能否找到needle。如果能找到，返回结果。
 *
 */
public class ImplementstrStr124 {
	
	public String strStr(String haystack, String needle) {
		//获取两个字符串的长度
		int length_a = haystack.length();
        int length_b = needle.length();
        //如果长度小于的时候，便是空；如果相等的时候，那么就判断字符串是否相等
        if(length_a < length_b)
            return null;
        if(length_a == length_b){
            if(haystack.equals(needle))
                return haystack;
            return null;
        }
        
        int i,j;
        //注意这个条件  如果后面剩余的长度不够了  那么haystack里面就不可能包含needle了
        for(i=0; i<=length_a-length_b; ++i){
		    boolean flag = true;
		    //从每一个位置开始遍历这个字符串   如果能找到  返回结果
            for(j=0; j<length_b; ++j){
                if(!haystack.substring(i+j,i+j+1).equals(needle.substring(j, j+1))){
                    flag = false;
                    break;
                }
            }
            if(flag)
                return haystack.substring(i);
	      
	    }
        
        return null;	
    }
}

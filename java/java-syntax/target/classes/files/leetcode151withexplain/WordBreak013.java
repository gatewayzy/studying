package _programming.leetcode151withexplain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 本题的题意是给一个字符串，然后给一次词典，问是否这个字符串可以由这个词典中的次拼凑出来。
 * 
 *  本体的解题思路：递归调用
 *  先求的所有词典中词的最短长度和最大长度，这个可以用来减少代码的运算；声明了一个map，map用来存储那些不可以被分解的字符串，也是为了剪枝使用的；
 *  然后通过递归的思想，不断的获取前缀，判断前缀是否在词典中，如果再词典中，那么就判断现在的后缀能否继续被分解，即采用递归调用的思想。
 *  
 *  
 *
 */
public class WordBreak013 {
	
	public boolean wordBreakHelper(String s,Set<String> dict,Set<String> unmatched,int mn,int mx) {  
        if(s.length() < 1) return true;
        
        //find the max length between mx and s.length
        int i = mx < s.length() ? mx : s.length(); 
        
        //其实就是深度优先遍历，只是每一个层次都有几种可能的结果
        for(; i >= mn ; i--){
        	
            String preffixstr = s.substring(0,i);  
            if(dict.contains(preffixstr) != false){  
                String suffixstr = s.substring(i); 
                //判断后缀是否在map中，如果在，那么就省去了很多计算。
                if(unmatched.contains(suffixstr) == true)  
                    continue;  
                else  
                	//递归调用
                    if(wordBreakHelper(suffixstr, dict, unmatched,mn,mx))  
                        return true;  
                    else  
                        unmatched.add(suffixstr);  
            }  
        }  
        return false;  
    }  
    
    public boolean wordBreak(String s, Set<String> dict) {  
        // Note: The Solution object is instantiated only once.  
        if(s.length() < 1) return true;  
        if(dict.size() == 0) return false;  
        Iterator<String> ite = dict.iterator();
        int minlen = 0;
        int maxlen = 0;
        //求出单词的最大长度和最小长度
        while(ite.hasNext()){
        	String cDict = ite.next();
        	if(minlen > cDict.length()){
        		minlen = cDict.length();
        	}
        	
        	if(maxlen < cDict.length()){
        		maxlen = cDict.length();
        	}
        	
        }

        Set<String> unmatched = new HashSet<>();  
        return wordBreakHelper(s,dict,unmatched,minlen,maxlen);  
    }
    
}

package _programming.leetcode151withexplain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 本题题意：给出一个字符串L和一组长度相等的字符串数组s，找到字符串L中包含所有s中字符串只一次的开始位置，而且该区间内不能有其他字符。
 * 
	For example, given:
	S: "barfoothefoobarman"
	L: ["foo", "bar"]
	You should return the indices: [0,9].
 *  
 *  解题思路：从L中的每一个位置开始往后遍历，看是否能够出现所需的所有字符串；通过map来记录住出现的次数，出现的次数太多也是错误，应该恰巧出现一样多的次数。而且该出现的都出现了。
 *
 */
public class SubstringwithConcatenationofAllWords122 {
	
	public List<Integer> findSubstring(String S, String[] L) {
		//通过一个map记录所有的字符串
        Map<String,Integer> words = new HashMap<String,Integer>();
        //cur用于记录出现了多少次
        Map<String,Integer> cur = new HashMap<String,Integer>();  
        int wordNum = L.length;
        
        //初始化，把每一个字符串都压入到结果集中
        for(int i = 0; i < wordNum; i++){
            if(words.get(L[i]) == null){
                words.put(L[i],1);
            }else{
               words.put(L[i],words.get(L[i])+1); 
            }
        }  
             
        //单词的长度    
        int wordLen = L[0].length();
        
        //结果集合
        List<Integer> res = new ArrayList<Integer>();
        
        //the i condition is very good  because the start position can not over S.length() - wordLen*wordNum
        //判断条件就是看看后面还能否出现所需的字符数目  可能后面的字符很少了  那就没有必要计算了
        //i是开始的位置
        for(int i = 0; i <= (int)S.length()-wordLen*wordNum; i++){  
            cur.clear();  
            int j;
            //judge if every word occur in the string
            //从每一个位置开始遍历字符串 看是否可以出现所需的所有字符串
            for(j = 0; j < wordNum; j++)  
            {  
                String word = S.substring(i+j*wordLen, i+j*wordLen+wordLen);
                //如果出现了不需要的字符
                if(words.get(word) == null)  
                    break;
                
                //如果当前出现的字符串还没出现过
                if(cur.get(word) == null){
                    cur.put(word,1);
                //已经出现过
                }else{
                    cur.put(word,cur.get(word)+1);
                }    
                //如果出现的次数超过了所需的次数
                if(cur.get(word) > words.get(word))  
                    break;  
            }
            //能否达到所需要的数目
            if(j == wordNum)  
                res.add(i);  
        }  
        return res;   
        
    }
}

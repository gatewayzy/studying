package _programming.leetcode151withexplain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 本题的题意就是给出所有的结果：
 * 
 *  本题思路：用一个字符串数组专门的存储结果，有一个字符串数组专门存储当前的字符串分解情况。
 *  
 *  1、先求出词典中词项的最短和最长；
 *  2、采用递归的思想，当边界条件成立的时候就可以获取结果。
 *    然后还是像深度优先遍历，每一层都有多种结果，然后每一个分解出来词项的压入都要弹出
 *
 */
public class WordBreakII012 {

	/**
	
class Solution {  
	public:  
    int max_word_length;  
    int min_word_length;  
    vector<string> current_breaks;  
    vector<string> generated_sentence;  
      
    void generate_sentence()  
    {  
        string s = current_breaks.back();  
        for(int i = int(current_breaks.size()) - 2; i >= 0; --i)  
            s += string(" ") + current_breaks[i];  
        generated_sentence.push_back(s);  
    }  
      
    void testWordBreak(const string& s, const unordered_set<string>& dict)  
    {  
        const int LEN_S = s.size();  
          
        //边界条件成立，生成结果  
        if (LEN_S == 0)  
        {  
            generate_sentence();  
            return;  
        }  
  
  		//深度优先遍历中的某一个层次，有多种可能，每一个可能都要考虑到
        for(int i = min_word_length; i <= min(max_word_length, LEN_S); ++i)  
        {  
            string substr = s.substr(LEN_S - i);  
            if (dict.find(substr) != dict.end())  
            {  
                current_breaks.push_back(substr);  
                testWordBreak(s.substr(0, LEN_S - i), dict);  
                current_breaks.pop_back();  
            }  
        }  
    }  
  
  
    vector<string> wordBreak(string s, unordered_set<string> &dict) {  
        generated_sentence.clear();  
          
        //下面求出了词项的最短长度和最长长度  
        max_word_length = 0;  
        min_word_length = 99999; // very large integer  
        for(auto& d : dict)  
            max_word_length = max(max_word_length, int(d.size())),  
            min_word_length = min(min_word_length, int(d.size()));  
              
        testWordBreak(s, dict);  
        return generated_sentence;  
    }  
}; 
	
	
	*/
	
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> results = new ArrayList<String>();
        if(s.length() < 1) return results;  
        if(dict.size() == 0) return results;  
        Iterator<String> ite = dict.iterator();
        int minlen = 0;
        int maxlen = 0;
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
        
        wordBreakDetail(results, "",unmatched, s, dict, minlen,maxlen); 
        return results;
    }
    
    public boolean wordBreakDetail(ArrayList<String> results, String temp, Set<String> unmatched,String s, Set<String> dict, int min,int max){
        if(s.length() == 0){
            results.add(temp);
            return true;
        }
        
        int i = s.length() > max? max : s.length();
        for(; i >= min; i--){
            String prefixs = s.substring(0,i);
            if(dict.contains(prefixs)){
                String suffers = s.substring(i);
                if(unmatched.contains(suffers) == true){
                   continue;
                }else{
                    String splitString = " ";
                    if(temp.equals(""))
                       splitString = ""; 
                       
                    if(!wordBreakDetail(results, temp+splitString+prefixs,unmatched, suffers, dict, min,max)){
                        unmatched.add(suffers);
                    } 
                }
                
            }
        }
        return false;
    }
	
    
    
    
    
    
	public static void main(String[] args){
		WordBreakII012 obj = new WordBreakII012();
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		
		obj.wordBreak("catsanddog", dict);
	}
    
}

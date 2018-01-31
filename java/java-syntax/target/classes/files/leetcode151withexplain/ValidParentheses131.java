package _programming.leetcode151withexplain;

import java.util.ArrayList;

/**
 * 本题题意：给出一个字符串，字符串中的字符都是括号，问该字符串是否是匹配的。
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 * 本题思路：遍历字符串的每一个元素，遇到右面元素，那么就要看栈顶元素现在能否找到匹配的情况，如果有，那么就弹出；这样就能匹配所有的情况。
 */
public class ValidParentheses131 {
	
		public boolean isValid(String s) {
           
			//模拟栈  对于这种匹配问题经常用到栈
		    ArrayList<String> likeStack = new ArrayList<String>();
	        
		    //特殊情况处理
	        int sLength = s.length();
	        if(sLength == 1) return false;
	        
	        //先压入一个
	        likeStack.add(s.substring(0,1));
	        
	        //开始往后面遍历
	        for(int i = 1; i < sLength; i++){
	            String tempS = s.substring(i,i+1);
	            
	            //获取栈顶元素  看是否匹配
	            int currentSize = likeStack.size();
	            
	            if(currentSize > 0){
	            
	   	            String topS = likeStack.get(currentSize-1);
	   	            
	   	            //如果现在的是）,那么就要看栈顶是否是(元素
	   	            if(tempS.equals(")")){
	   	                if(!topS.equals("(")) return false;
	   	                else{
	   	                	//如果匹配就弹出
	   	                	likeStack.remove(currentSize-1);
	   	                	//别忘了continue
	   	                	continue;
	   	                }
	   	            }
	   	            
	   	            //同样的道理  判断其他匹配情况
	   	            if(tempS.equals("}")){
	   	                if(!topS.equals("{")) return false;
	   	                else{ 
	   	                	likeStack.remove(currentSize-1);
	   	                	continue;
	   	                }
	   	            }
	   	            
	   	            if(tempS.equals("]")){
	   	                if(!topS.equals("[")) return false;
	   	                else{ 
	   	                	likeStack.remove(currentSize-1);
	   	                	continue;
	   	                }
	   	            }
	            }
	            
	            //否则就压入到栈中
	            likeStack.add(tempS);
	        }
	        
	        //判断栈里面还有元素与否
	        if(likeStack.size() > 0) return false;
	        
	        return true;
		}
}

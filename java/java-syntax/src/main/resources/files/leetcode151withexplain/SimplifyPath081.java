package _programming.leetcode151withexplain;

import java.util.Stack;

/**
 * 本题题意：给出一个unix路径  简化这个路径
 *
 *  For example,
	path = "/home/", => "/home"
	path = "/a/./b/../../c/", => "/c"
	
	
	本题思路：通过一个栈来模仿路径，不断的压入字符，要时刻记住前面的一个字符是什么。然后如果是。。/，那么在栈不为空的时候，则弹出一个字符；
	如果是//或者。/这样子的，那么就可以直接跳过了，如果是字符什么的就压入到栈中。
		
 */
public class SimplifyPath081 {
	
	public String simplifyPath(String path) {
		//用于模拟压入
        Stack<String> s = new Stack<String>();
		String str = "";
		
        for(int i = 0; i < path.length(); i++){
        	//如果当前字符是 /
            if (path.substring(i, i+1).equals("/")){
                //判断前面的字符  如果是../那么就往外弹出一层
            	if(str.equals("..")){
            	   //弹出
                   if (!s.empty())
                      s.pop();
                //如果是./或者是空，那么直接跳过就可以
                }else if (!str.equals(".") && !str.equals("")){
                    s.push(str);
                }
                str = "";
            }else{
            	//str用于记录当前不是/的时候的数值
                str += path.substring(i,i+1);
            }
        }
        
        //如果最后一个是..  那么还是弹出一个
        if (str.equals("..")){
            if (!s.empty())
                s.pop();
        //否则加入到栈中
        }else if (!str.equals(".") && !str.equals("")){
            s.push(str);
        }
        
        //如果栈为空，那么就直接返回
        if (s.empty())
            return "/";
        
        String ret = "";
        while(!s.empty()){
            ret = "/" + s.peek() + ret;
            s.pop();
        }
        
        return ret;
   }
}

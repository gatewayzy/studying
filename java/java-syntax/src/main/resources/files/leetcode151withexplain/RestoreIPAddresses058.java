package _programming.leetcode151withexplain;

import java.util.ArrayList;
import java.util.List;

/**
 * 本题题意:给出一个字符串   将其分解为正确的ip地址   并且返回结果
 * For example:
	Given "25525511135",
	
	return ["255.255.11.135", "255.255.111.35"]. 
	
	一般思路：按照深度优先遍历的方式，每一个层次的可能取值就是取1个数 2个数  3个数
 *
 *	
 */
public class RestoreIPAddresses058 {
	
	
	public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        if(s == null) return result;
        int sLength = s.length();
        //特殊处理
        if(sLength < 4 || sLength > 12) return result;
        getResult(result,"",s,0,0,sLength);
        return result;
    }
    
	/**
	 * 递归的调用获取结果   其实即使深度优先遍历
	 * @param result  结果 
	 * @param temp 临时结果
	 * @param s 原字符串
	 * @param dotNum 点好多少
	 * @param currentPosition  当前位置
	 * @param sLength s字符串的长度
	 */
    public void getResult(ArrayList<String> result,String temp,String s,int dotNum,int currentPosition,int sLength){
        //加.位置
    	if(dotNum > 0 && dotNum < 4){
        	temp = temp+".";
        }
        
    	//跳出条件
        if(currentPosition > sLength){
        	return;
        }
        
        //获取到了一个结果
        if(dotNum == 4 && currentPosition == sLength){
            result.add(temp);
            return;
        //虽然分为了四段，但是没有到字符串最后的位置
        }else if(dotNum == 4 && currentPosition != sLength){
        	return;
        }
        
        //深度优先遍历   截取 1位  2位  3位
        for(int i = 1; i <=3 && currentPosition + i <= sLength; i++){
        	
            String currentS = s.substring(currentPosition,currentPosition+i);
            //截取字符串如果合理，那么就递归调用
            if(isVail(currentS)){
            	//传递值的方式 
                getResult(result,temp + currentS,s,dotNum+1,currentPosition+i,sLength);
            }
        }
    }
    
    //判断一个字符串是不是合法的
    public boolean isVail(String s) {
    	//如果长度不为1 而且第一个还是0  这样的不合法
        if (s.length() != 1 && s.charAt(0) == '0') 
           return false;
        
        //计算字符串的大小  s.charAt(i) - '0'能够计算出数值  这个挺好用的
        int n = s.charAt(0) - '0';
        for (int i = 1; i < s.length(); ++i) {
            n *= 10;
            n += (s.charAt(i) - '0');
       }
        
       return n <= 255;
   }
    
    
    //another method
    public static List<String> restoreIpAddresses2(String s) {
        List<String> answer = new ArrayList<String>();
        getResult(answer,"",0,s.length(),0,s);
        return answer;
        
    }
    
    public static void getResult(List<String> answer, String temp, int curPos, int n, int potSize, String s){
        if(curPos == n && potSize == 4){
            answer.add(temp.substring(0,temp.length()-1));
            return;
        }
        
        if(potSize > 4) return;
        
        
        for(int i = 1; i <= 3 && (curPos + i) <= n; i++){
            String curS = s.substring(curPos,curPos+i);
            if(isVail2(curS)){
                getResult(answer,temp+curS+".",curPos+i,n,potSize+1,s);
            }
        }
    }
    
    public static boolean isVail2(String s) {
        if (s.length() != 1 && s.charAt(0) == '0') 
           return false;
        
        int n = s.charAt(0) - '0';
        for (int i = 1; i < s.length(); ++i) {
            n *= 10;
            n += (s.charAt(i) - '0');
       }
        
       return n <= 255;
   }
    
    
    public static void main(String[] args){
    	RestoreIPAddresses058.restoreIpAddresses2("0000");
    }
    
    
}

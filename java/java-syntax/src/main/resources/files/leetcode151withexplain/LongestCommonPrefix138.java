package _programming.leetcode151withexplain;

/**
 * 本题题意：给出一组字符串，找到所有字符串的公共前缀。
 * 
 * 解题思路：最粒子的操作时求两个字符串的公共前缀；然后通过二分法找到所有的最长公共子串。
 *
 */
public class LongestCommonPrefix138 {
	
	public String longestCommonPrefix(String[] strs) {
        //两种特殊情况处理
		if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        
        return getPartCommonPrefix(strs,0,strs.length-1);
    }
    
	/**
	 * 获取公共前缀
	 * @param strs
	 * @param startPosition  开始位置
	 * @param endPosition  结束位置
	 * @return
	 */
    public String getPartCommonPrefix(String[] strs,int startPosition,int endPosition){
    	//如果相等  返回当前字符串
        if(startPosition == endPosition){
            return strs[startPosition];
        }
        
        
        //如果当前就两个元素，那么就找到其公共子串
        if(startPosition == (endPosition-1)){
            return getCommonPrefix(strs[startPosition],strs[endPosition]);
        }
        
        //二分的方法
        int middle = (startPosition+endPosition)/2;
        //找到左边部分的公共前缀
        String leftString = getPartCommonPrefix(strs,startPosition,middle);
        //找到右边部分的公共前缀
        String rightString = getPartCommonPrefix(strs,middle+1,endPosition);
        //给出结果
        String result = getCommonPrefix(leftString,rightString);
        return result;
        
    }
    
    //粒子操作  给出两个字符串  求出其公共前缀
    public String getCommonPrefix(String a,String b){
        int aLength = a.length();
        int bLength = b.length();
        int size = aLength;
        if(aLength > bLength){
            size = bLength;
        }
        
        String result = "";
        for(int i = 0; i <size; i++){
            if(a.substring(i,i+1).equals(b.substring(i,i+1))){
                result += a.substring(i,i+1);
            }else{
                break;
            }
        }
        
        return result;
    }
}

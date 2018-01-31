package _programming.leetcode151withexplain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 本题题意：给出一组字符串，获取里面所有反转的字符串。爱呢格热爱目日
 * 
 * 解题思路：通过一个map来计算，map的key用于记录字符串，map的value用于记录字符串的所有颠倒字符串。
 * 通过map这一数据结构，简化了计算。
 * 
 *
 */
public class Anagrams104 {
	
 	public List<String> anagrams(String[] strs) {
 		//用于记录结果
        List<String> answer = new ArrayList<String>();
        int strsLength = strs.length;
        if(strsLength == 0) return answer;
        
        //map的key用于存储String，value用于存储和其颠倒顺序的所有字符串
        Map<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
        for(int i = 0; i < strsLength; i++){
            String s = strs[i];
            //转化为字符数组
            char[] schar = s.toCharArray();
            //对数组进行排序
            Arrays.sort(schar);
            String stemp = String.valueOf(schar);
            //看看当前字符串是否已经存在于map中，如果存在，那么就把现有的字符串加到value中，如果不存在，那么就压入一个新的数值
            if(map.get(stemp) == null){
                ArrayList<String> value = new ArrayList<String>();
                value.add(s);
                map.put(stemp,value);
            }else{
                map.get(stemp).add(s);
            }
        }
        
        //遍历map中的每一个value，当value的大小>1的时候，就说明存在颠倒的字符串
        for(Map.Entry<String,ArrayList<String>> entry : map.entrySet()){
            if(entry.getValue().size() > 1){
                answer.addAll(entry.getValue());
            }
        }
        
        return answer;
    }
}

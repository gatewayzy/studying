package _programming.leetcode151withexplain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 本题题意：给出一个数组，数组中可能还有重复的数字，给出所有的排列情况
 *
 */
public class PermutationsII106_DoAgain {
	
	public List<List<Integer>> permuteUnique(int[] num) {
		//通过set来存储结果，这样便可以去除重复的元素
		Set<ArrayList<Integer>> tempResult =  getPermute(num,num.length-1);
		//留意这个声明方式List<List> = ArrayList<List>
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		//把set中的数据取出，赋值给result
		for(ArrayList<Integer> tempR : tempResult){
			result.add(tempR);
		}
		return result;
    }
    
	/**
	 * 获取排列结果
	 * @param num  数组数据
	 * @param currentPosition  当前遍历到的位置
	 * @return
	 */
    public Set<ArrayList<Integer>> getPermute(int[] num, int currentPosition){
        //用set记录结果Set<ArrayList> = HashSet<ArrayList>
    	Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
        
    	//如果当前位置是最后一个，那么返回结果，即边界条件
        if(currentPosition == 0){
        	ArrayList<Integer> currentR = new ArrayList<Integer>();
            currentR.add(num[0]);
            result.add(currentR);
            return result;
        }
        
        //获取下一轮的结果，然后在结果中的每一个位置插入当前元素，那么就是一个新的排列
        Set<ArrayList<Integer>> nextResult = getPermute(num,currentPosition-1);
        for(ArrayList<Integer> oneResult : nextResult){
            int size = oneResult.size();
            //对于每一个元素的每一个位置，都插入当前的值
            for(int i = 0; i <= size; i++){
                oneResult.add(i,num[currentPosition]);
                result.add(new ArrayList(oneResult));
                //别忘了插入之后再删除掉
                oneResult.remove(i);
            }
        }
        
        return result;
    }
}

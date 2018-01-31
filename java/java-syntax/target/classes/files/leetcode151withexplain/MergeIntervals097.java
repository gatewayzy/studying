package _programming.leetcode151withexplain;

import java.util.ArrayList;
import java.util.List;

/**
 * 本题题意：给出一些区间   返回区间合并之后的结果
 * 
 * 解题思路：和96题一样   把问题想象成在一条线上描颜色
 *
 */
public class MergeIntervals097 {
	
	//区间  数据结构
	public class Interval {
		 int start;
		 int end;
		 Interval() { start = 0; end = 0; }
		 Interval(int s, int e) { start = s; end = e; }
	}
	
	class Item{
        boolean dot;
        boolean nextValue;
        Item(boolean d, boolean n){
            dot = d;
            nextValue = n;
        }
    }
	
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> answer = new ArrayList<Interval>();
        int intervalSize = intervals.size();
        if(intervalSize == 0){
            return answer;
        }
        
        int minNum = intervals.get(0).start;
        int maxNum = 0;
        for(int i = 0; i < intervalSize; i++){
            Interval currentInterval = intervals.get(i);
            int end = currentInterval.end;
            maxNum = end > maxNum? end : maxNum;
        }
        
       
        ArrayList<Item> itemFlag = new ArrayList<Item>();
        for(int u = 0; u < maxNum+1; u++){
            Item newi = new Item(false,false);
            itemFlag.add(newi);
        }

        for(int i = 0; i < intervalSize; i++){
            Interval currentInterval = intervals.get(i);
            int start = currentInterval.start;
            int end = currentInterval.end;
            if(start == end){
                itemFlag.get(start).dot = true;
            }else{
                for(int j = start; j < end; j++){
                    itemFlag.get(j).nextValue = true;
                }
            }
        }
        
        for(int i = 0; i <= maxNum; i++){
            if(itemFlag.get(i).dot == true && itemFlag.get(i).nextValue == false){
               if(i > 0 && itemFlag.get(i-1).nextValue == false){
                    Interval newItem = new Interval(i,i);
                    answer.add(newItem);
               }else if(i == 0){
                   Interval newItem = new Interval(i,i);
                   answer.add(newItem);
               }
            }else if(itemFlag.get(i).nextValue == true){
                
                int start = i;
                int end = i;
                while(itemFlag.get(end).nextValue == true && end <= maxNum){
                    end++;
                    i++;
                }
                
                if(i > 0) i--;
                Interval newItem = new Interval(start,end);
                answer.add(newItem);

            }else{
                continue;
            }
        }
        
        return answer;
    }
}

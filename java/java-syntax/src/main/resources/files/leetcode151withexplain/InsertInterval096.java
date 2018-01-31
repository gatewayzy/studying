package _programming.leetcode151withexplain;

import java.util.ArrayList;
import java.util.List;

/**
 *	本题题意：给出一组区间，区间是没有覆盖区域的，区间是按开始节点的递增进行排序的。给出一组区间，用于插入到原有的区间中，然后求出合并后的区间。
 *
 *	Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * 	
 * 	本题思路：把问题想象成一条线，然后在线上描颜色；如果是点的，那么就是描一个点；如果是一个区间，那么就是描述一段区间。最后遍历这条线，就能知道哪些段是答案；构建了一个数据结构，用于记录当前点是一个点还是下面
 * 一个区间。
 *
 */
public class InsertInterval096 {
	
	 //区间的数据结构
	 public class Interval {
		 int start;
		 int end;
		 Interval() { start = 0; end = 0; }
		 Interval(int s, int e) { start = s; end = e; }
	}
	
	//是一个点，还是下一阶段的值
	class Item{
        boolean dot;
        boolean nextValue;
        Item(boolean d, boolean n){
            dot = d;
            nextValue = n;
        }
    }
    
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	
        List<Interval> answer = new ArrayList<Interval>();
        int intervalSize = intervals.size();
        //特殊情况处理
        if(intervalSize == 0){
            answer.add(newInterval);
            return answer;
        }
        
        //获取给出的区间的最大值
        int preMaxNum = intervals.get(intervalSize-1).end;
        //给出的新区间的最大值
        int newMaxNum = newInterval.end;
        
        //知道所有区间的最大值
        int maxNum = preMaxNum > newMaxNum? preMaxNum : newMaxNum;
        
        //初始化itemFlag
        ArrayList<Item> itemFlag = new ArrayList<Item>();
        for(int u = 0; u < maxNum+1; u++){
            Item newi = new Item(false,false);
            itemFlag.add(newi);
        }

        //遍历每一个区间  然后设置itemFlag
        for(int i = 0; i < intervalSize; i++){
            Interval currentInterval = intervals.get(i);
            int start = currentInterval.start;
            int end = currentInterval.end;
            //如果区间起始位置相同  那么dot设置为true
            if(start == end){
                itemFlag.get(start).dot = true;
            }else{
            	//否则对应的下一个区间设置为true
                for(int j = start; j < end; j++){
                    itemFlag.get(j).nextValue = true;
                }
            }
        }
        
        //同样的道理，将新区间添加到itemFlag中
        int newIntervalStart = newInterval.start;
        int newIntervalEnd = newInterval.end;
        if(newIntervalStart == newIntervalEnd){
            itemFlag.get(newIntervalStart).dot = true;
        }else{
            for(int k = newIntervalStart; k < newIntervalEnd; k++){
               itemFlag.get(k).nextValue = true;
            }
        }
        
        //遍历标示好的最新数据
        for(int i = 0; i <= maxNum; i++){
        	//如果是一个节点
            if(itemFlag.get(i).dot == true && itemFlag.get(i).nextValue == false){
                //如果前面是一个区间，那么说明现在的点可以囊括到区间中
            	if(i > 0 && itemFlag.get(i-1).nextValue == false){
                    Interval newItem = new Interval(i,i);
                    answer.add(newItem);
               //如果是第一个点，那么就是一个点
               }else if(i == 0){
                   Interval newItem = new Interval(i,i);
                   answer.add(newItem);
               }
            }else if(itemFlag.get(i).nextValue == true){
                
                int start = i;
                int end = i;
                //如果是一个区间，然后往后遍历
                while(itemFlag.get(end).nextValue == true && end <= maxNum){
                    end++;
                    i++;
                }
                
                //别忘了减掉多加的1
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

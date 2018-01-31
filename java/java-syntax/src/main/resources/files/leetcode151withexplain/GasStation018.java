package _programming.leetcode151withexplain;

/**
 * 本题题意：在一个环上有n个加油站，每个加油站都有gas[i]的汽油，汽车中一个汽油站到另外一个汽油站消耗汽油cost[i],问汽车能否转一圈。
 * 
 *  贪心的方式，通过sum记录当前某一段内还有多少汽油，如果sum小于零了，那么说明跑不下去了；然后将start设置为当前的下标值；total变量用于记录走完一圈之后的汽油量，如果汽油量小于0，那么
 *  说明汽车不能跑一圈。
 *  
 *  为什么start直接设置为当前下标的下一个；如果选择的是当前的位置开始，那么后面这一段肯定还会出现问题，因为至少第一个节点是成功的，后面不成功的原因肯定出在后面的问题上。
 *
 */
public class GasStation018 {
	
	public int canCompleteCircuit(int[] gas, int[] cost) { 
        int sum=0;
        int total=0;
        int start=0;
        
        for(int i=0;i<gas.length;i++)
        {
        	//记录当前段汽油剩余量
            sum += gas[i]-cost[i];
            
            //记录总的汽油剩余量
            total += gas[i]-cost[i];
            if(sum < 0)
            {
            	//start设置为下一个下标值
                start=(i+1)%gas.length;
                sum=0;
            }
        }
        
        if(total <0)
            return -1;
        else
            return start;
    }
}

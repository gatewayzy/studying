package _programming.leetcode151withexplain;

/**
 * 本题题意：给出了一个股票的价格，然后 买了再卖，求出最大的价格
 * 
 * 解题思路：那么只要知道以后的股票的最大值就好了，那么我就可以在那天卖掉。
 * 
 * 所以通过一个数组记录住每一个位置后面能够出现的最大值。
 *
 */
public class BestTimetoBuyandSellStock030 {

	public int maxProfit(int[] prices) {
        
        //use an array to remember the max number after the ith element
        int pricesSize = prices.length;
        
        //用于记录当前节点后面可能出现的最大节点值
        int[] maxNumbers = new int[pricesSize];
        int tempMax = 0;
        
        //从后面向前遍历
        for(int i = pricesSize-1; i >= 0; i--){
            if(tempMax < prices[i]){
                tempMax = prices[i];
            }
            maxNumbers[i] = tempMax;
        }
        
        //go through this arry and find the answer
        int answer = 0;
        for(int j = 0; j < pricesSize; j++){
            if(answer < (maxNumbers[j] - prices[j])){
                answer = maxNumbers[j] - prices[j];
            }
        }
        
        return answer;
    }
}

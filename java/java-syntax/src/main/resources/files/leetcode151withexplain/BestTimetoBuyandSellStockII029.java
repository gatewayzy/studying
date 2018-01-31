package _programming.leetcode151withexplain;

/**
 * 本题题意：股票的处理可以买卖很多次，但是只有卖了才能重新买。
 * 
 *  那么我就遍历，只要第二天比今天的高，我就买了就卖。贪心方法，最终结果正确。
 *  
 *
 */
public class BestTimetoBuyandSellStockII029 {
	
	public int maxProfit(int[] prices) {    
        int answer = 0;
        int pricesSize = prices.length;
        //一次遍历计算结果
        for(int i = 0; i < (pricesSize-1); i++){
            if(prices[i+1] > prices[i]){
                answer += prices[i+1] - prices[i];
            }
        }
        
        return answer;
        
    }
}

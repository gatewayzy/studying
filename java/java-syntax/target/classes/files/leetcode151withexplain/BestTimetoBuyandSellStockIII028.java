package _programming.leetcode151withexplain;

/**
 * 
 * 可以做两次交易，求交易额最大
 * 
 * 传统的思路：既然是两次交易  那么可以先知道如何求一次交易的最大值，然后把每一个位置作为切分点，求出最大值就可以了。
 * 
 * 本题的思路和上面的思路不太一样：
 * 用两个数组记录以下数值：
 * lefttorightProfit：如果再某一个位置卖的话，利润大概是多少
 * 
 * righttoleftProfit：如果再某一个位置买的话，利润大概是多少
 * 
 */
public class BestTimetoBuyandSellStockIII028 {
	
	public int maxProfit(int[] prices){
        if(prices == null || prices.length == 0 || prices.length == 1){
            return 0;
        }
        int priceLength = prices.length;
        int[] lefttorightProfit = new int[priceLength];
        int[] righttoleftProfit = new int[priceLength];
        
        //最小值去第一个价格元素
        int min = prices[0];
        //从开始往后遍历，如果大于最小值，记录住可以获取的利益。如果不是，那么就和前面的利益一致；{即：记录住每一个节点可以赢得的利润是多少，即在某一个节点卖的话，价格是多少}
        for(int i = 1; i < priceLength; i++){
            lefttorightProfit[i] = prices[i] - min > lefttorightProfit[i-1]? prices[i] - min : lefttorightProfit[i-1];
            //min一直去最小值
            min = prices[i] < min? prices[i]:min;
        }
        
        //如果在j位置买的话，后续利润大概是多少（即，在j位置买的话，大概价值是多少）
        int max = prices[priceLength-1];
        for(int j = priceLength-2;j >= 0; j--){
            righttoleftProfit[j] = max - prices[j] > righttoleftProfit[j+1]? max - prices[j]:righttoleftProfit[j+1];
            max = prices[j] > max? prices[j] : max;
        }
        
        //遍历两个数组：某节点处卖的利润和某节点买的利润之和便是两次的价格
        int result = 0;
        for(int k = 0; k < priceLength; k++){
            if(lefttorightProfit[k] + righttoleftProfit[k] > result){
                result = lefttorightProfit[k] + righttoleftProfit[k];
            }
        }
        
        return result;
    }
}

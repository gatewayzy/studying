package _programming.leetcode151withexplain;

/**
 *  http://blog.csdn.net/doc_sgl/article/details/13418125
 *  本题题意：讲一个给定的字符串变成每个子串都是回文，最少要切分多少次 
 *
 */
public class PalindromePartitioningII020_Hard {

	public int minCut(String s) {
	    
	    int n=s.length();
	    
	    //采用动态规划的思想：dp[i]表示从i到n的最小切分次数
	    int[] dp=new int[n+1];
	    
	    //是否是回文的动态规划问题 pos[i][j]代表字符串从i到j是否是一位回文
	    boolean[][] pos=new boolean[n][n];
	    
	    //是否为回文的初始化过程
	    int i,j;
	    for(i=0; i<n; i++)
	       for(j=0 ; j<n;j++)
	           pos[i][j]=false;
	    
	    for(i = 0; i < n; i++){
		   pos[i][i] = true;
	    }
	    
	    
	    //dp初始化  初始化为后面的字符串最多可以切分多少次
	    //D[i] = 区间[i,n]之间最小的cut数，n为字符串长度， 则,
	    //D[i] = min(1+D[j+1] )    i<=j <n
	    for(i = 0; i<=n; i++){
	       dp[i]=n-i;
	    }
	    
	    
	    for (i=n-1;i>-1;i--)
	        for(j=i;j < n;j++)
	           if(s.substring(i,i+1).equals(s.substring(j,j+1)) && (j-i<2 || pos[i+1][j-1]))
	           {
	              pos[i][j]=true;
	              dp[i] = dp[j+1]+1 > dp[i] ? dp[i]:(dp[j+1]+1);
	           }
	           
	    
	    int min=dp[0];
	    return min-1;
    }
}

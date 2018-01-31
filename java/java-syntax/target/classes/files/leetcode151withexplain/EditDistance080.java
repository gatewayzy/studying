package _programming.leetcode151withexplain;

/**
 * 本题题意：给出两个单词  求出其编辑距离 
 *
 */
public class EditDistance080 {
	
	public int minDistance(String word1, String word2) {
		
		//编辑距离
		int word1Length = word1.length();
        int word2Length = word2.length();
        
        //特殊处理
        if(word1Length == 0){
            return word2Length;
        }
        
        if(word2Length == 0){
            return word1Length;
        }
        
        //声明一个二维矩阵   dp运算
        int[][] f = new int[word1Length+1][word2Length+1];
        
        //初始化二维矩阵  初始化行和列
        for(int i = 0; i <= word1Length; i++){
            f[i][0] = i;
        }
        
        for(int j = 0; j <= word2Length; j++){
            f[0][j] = j;
        }
        
        //编辑距离dp
        //dp[i][j] = min(dp[i-1][j-1]+f(i,j)[替换某个元素],dp[i-1][j]+1【插入元素】, dp[i][j-1]+1【删除元素】);
        for(int p = 1; p <= word1Length; p++){
            for(int q = 1; q <= word2Length; q++){
                int cost = 1;
                if(word1.substring(p-1,p).equals(word2.substring(q-1,q))){
                    cost = 0;
                }
                    
                f[p][q] = min(f[p-1][q-1]+cost,min(f[p-1][q]+1,f[p][q-1]+1)); 
                    
            }
        }
        
        return f[word1Length][word2Length];
        
    }
    
    
    public int min(int a, int b){
        if(a > b){
            return b;
        }else{
            return a;
        }
    }
}

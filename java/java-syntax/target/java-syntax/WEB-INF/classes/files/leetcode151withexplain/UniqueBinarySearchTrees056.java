package _programming.leetcode151withexplain;

/**
 *  本题题意：给出n，判断有多少个独特的二叉搜索树可以用来表示1-n
 *  
 *  Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

	For example,
	Given n = 3, there are a total of 5 unique BST's.
	
	   1         3     3      2      1
	    \       /     /      / \      \
	     3     2     1      1   3      2
	    /     /       \                 \
	   2     1         2                 3
	   
	本题思路：
 *	递归调用，每一个树作为根节点的时候的搜索树种类相乘然后相加就可以    递归调用的边界条件非常重要 
 */
public class UniqueBinarySearchTrees056 {
	
	public int numTrees(int n) {
		//递归的边界条件  
        if(n == 0){
            return 1;
        }
        
        //如果是一个节点  返回1
        if(n == 1){
            return 1;
        }
        
        //如果是两个节点  返回2
        if(n == 2){
            return 2;
        }

        //遍历从开始到结束  左子树种类乘以右子树种类
        int result = 0;
        for(int i = 1; i <= n; i++){
            result +=  numTrees(i-1) * numTrees(n-i);
        }
        
        return result;
           
    }
}

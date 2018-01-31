package _programming.leetcode151withexplain;

/**
 * 本题题意：给出一组非负数字，a1就代表在点1处有条线高度为a1,给出n个这种数据，求出两条线之间的容积最大。
 * 
 * 
 * 解题思路：和传统的从数组中找到两个元素的方法差不多，就是从两端开始往中间遍历。容器的大小计算方式就是两个线中比较短的乘以两条线之间的间隔。 
 *
 */
public class ContainerWithMostWater141 {
	
	 public int maxArea(int[] height) {    
        //A new function
        int totalSize = height.length;
        
        //特殊情况处理
        if(totalSize == 1){
            return height[0];
        }
        
        int mostWater = 0;
        int tempWater = 0;
        int left = 0;
        int right = totalSize-1;
        //从左右两边往中间压缩
        while(left < right){
            
        	//如果左边大于右边  那么计算容积就按右边的高度为准
            if(height[left] > height[right]){
                tempWater = height[right] * (right-left);
            }else{
                tempWater = height[left] * (right-left);
            }
            
            //找到当前的最大值
            if(mostWater < tempWater){
                mostWater = tempWater;
            }
            
            //从两头往中间压缩范围
            if(height[left] > height[right]){
                right--;
            }else{
                left++;
            }
            
        }
        return mostWater;
    }
	 
}

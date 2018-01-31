package _programming.leetcode151withexplain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 平面上有很多点，求出平面中在一条线上最多的点数
 * 解题思路：在同一条线上，那么这条线上两两点之间的斜率一定相等（包括X值相同，斜率为无穷大）。那么以每一个点为基点，遍历所有的点，求出与基点之间的斜率，这样便可以知道一条线上的点最多是多少。对于斜率无穷大的
 * 情况，可以单独处理，即记录住所有x值与基点数值相同的点。
 *
 * 时间复杂度O（n^2）
 */
public class MaxPointsonaLine003 {

	  //结构体
	  class Point {
	      int x;
	      int y;
	      Point() { x = 0; y = 0; }
	      Point(int a, int b) { x = a; y = b; }
	  }
	 
	    public int maxPoints(Point[] points) {
	    	//记录最大数量  X坐标相同 重叠点等
            int maxNum = 0;
		    int xequalsMaxNum = 0;
		    int duplicate = 0;
		    
		    //借助map来存储某斜率下的点的个数
		    Map<Double, Integer> results = new HashMap<>();
		    
		    
		    //遍历每两个点
		    for(int i = 0; i < points.length; i++){
		    	
		    	xequalsMaxNum = 0;
		    	duplicate = 0;
		    	results.clear();
		    	//遍历所有点
		    	for(int j = 0; j < points.length; j++){
		    		
		    		//处理自身
		    		if(j == i){
		    			duplicate++;
		    			xequalsMaxNum++;
		    			continue;
		    		}
		    		
		    		//处理重复点 处理完就continue
		    		if((points[j].y == points[i].y) && (points[j].x == points[i].x)){
		    			duplicate++;
		    			xequalsMaxNum++;
		    			continue;
		    		}
		    		
		    		//处理x相同的点，因为无法计算斜率，所以在此要特殊记录这种X相同的点
		    		if(points[j].x == points[i].x){
		    			xequalsMaxNum++;
		    		}else{
		    			//计算斜率，别忘了强制类型转换
		    			double slope = (double)(points[j].y - points[i].y)/(double)(points[j].x - points[i].x);
		    			if(results.get(slope) == null){
		    				results.put(slope, 1);
		    			}else{
		    				int times = results.get(slope);
		    				results.remove(slope);
		    				results.put(slope, times+1);
		    			}
		    			
		    		}
		    		
		    	}
		    	
		    	
		    	//获取本轮的最大值
		    	Collection<Integer> values = results.values();
		    	for(Iterator<Integer> ite = values.iterator();ite.hasNext();){
		    		int currentValue = ite.next();
		    		if(maxNum < currentValue+duplicate){
		    			maxNum =  currentValue+duplicate;
		    		}
		    	}
		    	
		    	//X轴相同也算是一种斜率，要单独比较
		    	if(maxNum < xequalsMaxNum){
		    		maxNum = xequalsMaxNum;
		    	}
		    	
		    }

			return maxNum;      
	    }

}

package _programming.leetcode151withexplain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 本题题意就是克隆一个图，图的数据结构已经给出。 
 * 
 * 本题思路：根据图的宽度优先遍历解决问题，通过一个linklist来模仿队列，先进先出；通过一个isFound用来记录住节点有没有被访问过，如果已经被访问过，那么就直接跳过；
 * 用nodemap存储节点，这样方便快速的找到节点。
 * 
 * 注意细节：1是头结点的巧妙设置；二是遍历邻居的时候，如果nodemap中已经存在，那么就直接加入到邻居中，如果不存在，新建节点，加入到邻居中，而且还要压入到队列中
 * 
 * nodemap和isfound有点相似之处，因为都是用于记录是否之前已经访问过了。
 *
 */
public class CloneGraph019 {
	
	//数据结构
	class UndirectedGraphNode {
		 int label;
		 List<UndirectedGraphNode> neighbors;
		 UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	};
	
	
	    Map<Integer, UndirectedGraphNode> nodeMap = new HashMap<Integer, UndirectedGraphNode>();  
	    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {  
	        //特殊情况处理
	        if (node == null) {  
	            return null;  
	        }  
	        
	        //模拟广度优先遍历中的队列
	        LinkedList<UndirectedGraphNode> stack = new LinkedList<UndirectedGraphNode>();  

	        
	        nodeMap.clear();
	        
	        //是否已经被访问过
	        Set<Integer> isFound = new HashSet<Integer>();
	          
	        //将节点放到最后的位置，压入队列
	        stack.addLast(node);
	        
	        //结果中的第一个节点
	        UndirectedGraphNode head = null;  
	          
	        //采用广度优先遍历的方式获取所有的节点
	        while (!stack.isEmpty()) {
	        	
	        	//获取队列的第一个元素
	            UndirectedGraphNode first = stack.getFirst();  
	            stack.removeFirst();  
	              
	            int label = first.label;  
	              
	            //新建节点
	            UndirectedGraphNode n = nodeMap.get(label);  
	            if (n == null) {  
	                n = new UndirectedGraphNode(label);  
	                nodeMap.put(label, n);  
	            }  
	              
	            //第一个节点的特殊处理
	            if (head == null) {  
	                head = n;  
	            }  
	              
	            if (!isFound.contains(label)) {
	            	//将节点压入到是否已被访问过列表中
	                isFound.add(label);  
	                
	                //获取原节点的所有邻居
	                ArrayList<UndirectedGraphNode> neighbors = (ArrayList<UndirectedGraphNode>) first.neighbors;  
	                  
	                //遍历每一个邻居节点，然后在nodemap中加入，并且设置为n的邻居
	                for (UndirectedGraphNode nb : neighbors) {  
	                    UndirectedGraphNode nn = nodeMap.get(nb.label);  
	                    if (nn == null) {  
	                        nn = new UndirectedGraphNode(nb.label);  
	                        nodeMap.put(nb.label, nn);  
	                          
	                        stack.addLast(nb);  
	                    }  
	                    n.neighbors.add(nn);         
	                }  
	            }  
	              
	              
	        }  
	          
	        return head;  
	    }

}

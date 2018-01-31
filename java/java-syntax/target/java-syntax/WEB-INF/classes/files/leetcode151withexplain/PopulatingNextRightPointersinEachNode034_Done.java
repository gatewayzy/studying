package _programming.leetcode151withexplain;

import java.util.ArrayList;
import java.util.List;

/**
 * 本题题意：给出一个二叉树   二叉树的每一层上面的节点next指针都指向本行的下一个元素
 * 
 * 本题假设：满二叉树
 * 
 * Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
	After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
    
    本题的思路：既然是满二叉树，那么之间就存在这种关系，就是每一行的数据量为2^i次方个
    
    用一个arraylist记录住所有的节点，用一个arraylist来模仿队列，通过宽度优先遍历所有的节点。然后根据每一行的这个数目关系，设置next指针。
    
  特殊要求：使用常量空间
    
 *
 */
public class PopulatingNextRightPointersinEachNode034_Done {

	//数据结构  三个指针  左右子树和下一个
	public class TreeLinkNode {
		 int val;
		 TreeLinkNode left, right, next;
		 TreeLinkNode(int x) { val = x; }
	}
	
	public void connect(TreeLinkNode root) {
		
        //record every element
        List<TreeLinkNode> allNodes = new ArrayList<TreeLinkNode>();
        //act as the BFS queue
        List<TreeLinkNode> likeQueue = new ArrayList<TreeLinkNode>();
        
        if(root == null){
            return;
        }else{
            likeQueue.add(root);
            allNodes.add(root);
        }
        
        while(likeQueue.size() != 0 && likeQueue.get(0) != null){
            TreeLinkNode queueHead = likeQueue.get(0);
            if(queueHead.left != null){
                allNodes.add(queueHead.left);
                likeQueue.add(queueHead.left);
            }
            
            if(queueHead.right != null){
                allNodes.add(queueHead.right);
                likeQueue.add(queueHead.right);
            }
            likeQueue.remove(0);
        }
        
        int temp = 0;
        int currentPosition = 0;
        int circle = 0;
        while(currentPosition < allNodes.size()){
            temp = currentPosition + (int)(Math.pow(2,circle));
            while(currentPosition < temp){
                if(currentPosition == (temp-1)){
                    allNodes.get(currentPosition).next = null;
                }else{
                    allNodes.get(currentPosition).next = allNodes.get(currentPosition+1);
                }
                currentPosition++;
            }
            circle++;
        }
        
    }
	
	//常量空间下的方式
	public void connect1(TreeLinkNode root) {
        if(root == null) return;
        //当前节点的下一个节点
        TreeLinkNode curNode = root.next;
        //找到当前节点的孩子节点应该指向的下一个节点
        TreeLinkNode nextNode = null;
        
        //循环获取下一个可以指向的地址
        while(curNode != null){
            if(curNode.left != null){
                nextNode = curNode.left;
                break;
            }
            
            if(curNode.right != null){
                nextNode = curNode.right;
                break;
            }
            curNode = curNode.next;
        }
        
        if(root.right != null){
            root.right.next = nextNode;
        }
        
        if(root.left != null){
            root.left.next = (root.right != null)?root.right:nextNode;
        }
        
        connect(root.right);
        connect(root.left);
        
    }
}

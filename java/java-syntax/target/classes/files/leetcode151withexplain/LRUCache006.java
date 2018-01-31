package _programming.leetcode151withexplain;

import java.util.HashMap;
import java.util.Map;

/**
 * 本题题意：模拟LRU latest recently userd 最近最少使用。
 * 
 * 即把最近使用的排在前面。
 * get函数用于获取是否cache中有该元素；
 * set函数设置cache中的值，如果已经存在，那么就改变value；如果不存在，那么就把新元素放到头部；
 * 如果容量超标了，那么就把排在最后的元素删除掉。
 * 
 * 本体解题思路：
 * 通过双链表模拟队列，那么就有个头和尾巴，这样方便从头部插入元素以及从尾部删除元素。
 * 通过一个map来存储节点中的节点，这样就方便查找节点，从而对节点做相关的操作。
 *
 */
public class LRUCache006 {
	   //双链表节点的数据结构
	    class Node{
	        Node pre;
	        Node next;
	        int key;
	        int value;
	        Node(int k, int v){
	            key = k;
	            value = v;
	            pre = null;
	            next = null;
	        }
	    }
	    
	    public int cacheCapacity;
	    public int currentSize;
	    public Node head;
	    public Node tail;
	    Map<Integer,Node> map = new HashMap<Integer,Node>();
	    
	    //构造函数   生命了头部和尾部  双链表
	    public LRUCache006(int capacity) {
	        this.cacheCapacity = capacity;
	        this.currentSize = 0;
	        map.clear();
	        head = new Node(0,0);
	        tail = new Node(0,0);
	        head.next = tail;
	        tail.pre = head;
	    }
	    
	    //获取元素如果不为空，别忘记了双链表的头尾设置
	    public int get(int key) {
	        Node keyNode = map.get(key);
	        if(keyNode != null){
	            keyNode.pre.next = keyNode.next;
	            keyNode.next.pre = keyNode.pre;
	            putToHead(keyNode);
	            return keyNode.value;
	        }else{
	            return -1;
	        }
	    }
	    
	    public void set(int key, int value) {
	        Node keyNode = map.get(key);
	        if(keyNode != null){
	            keyNode.value = value;
	            keyNode.pre.next = keyNode.next;
	            keyNode.next.pre = keyNode.pre;
	            putToHead(keyNode);
	        }else{
	            Node newnode = new Node(key,value);
	            map.put(key,newnode);
	            putToHead(newnode);
	            this.currentSize++;
	            if(currentSize > cacheCapacity){
	                map.remove(tail.pre.key);
	                tail.pre.pre.next = tail;
	                tail.pre = tail.pre.pre;
	                this.currentSize--;
	            }
	 
	        }
	    }
	    
	    //将元素插入到头部
	    public void putToHead(Node p){
	        p.next = head.next;
	        p.pre = head;
	        head.next.pre = p;
	        head.next = p;
	    }
}

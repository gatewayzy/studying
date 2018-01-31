package javaStructs;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by dell on 2017/7/22.
 */
public class _01Map {

    /**
     * HashMap 线程不安全，
     * 默认：Node[16]，使用率超过0.75则进行数组翻倍扩容。Node(k，v，k的hash，Node next)。
     * 整体上就是一个数组构成hash bucket （hash桶），桶里用链表存放具有key的hashCode相同的node。桶内node根据key进行equals比较。
     * put时，由key的hashCode确定桶，由key存入node，有key equals的就覆盖值。
     * get时，由key的hashCode确定桶，由key取出node，没有就返回null。
     */
    Map<String, Character> map1 = new HashMap<>();
//    map1.put(null,null);


    Map<String, Integer> hashtable = new Hashtable<>();

    Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();

    Map<String, String> synchronizedHashMap = Collections.synchronizedMap(new HashMap<>());
//    synchronizedHashMap.
}

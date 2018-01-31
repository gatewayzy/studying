package jdk8;

import java.util.HashMap;
import java.util.Map;

/**
 * Map接口类也有自己的增强
 * Stream是针对collection接口类的增强，不能用到Map接口上
 * Created by dell on 2017/7/20.
 */
public class _09MapEnhanced {
    /**
     * Map 接口中添加了大量的 default 方法进行功能增强
     */
    public static void main(String[] args) {
        System.out.println("=======  Map接口添加的default 方法有 putIfAbsent、 computeIfAbsent、 compute 等等");
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);  // default 方法 putIfAbsent 会先判断get(key)是否为null（所以没有这个key或者key对应的是null）才会进行put操作，否则不put
        }
        map.forEach((id, val) -> System.out.println(val));  // map的forEach也支持 函数式编程，需要传入BiConsumer （对两个参数进行操作的consumer）

        System.out.println("======= computeIfPresent (K key,  BiFunction<? super K, ? super V, ? extends V> remappingFunction)");
        map.computeIfPresent(3, (key, oldValue) -> key + ": " + oldValue);  // key 出现时进行操作
        System.out.println(map.get(3));          // val33
        map.put(0, null); //   Map本身是支持存放 v = null 的，但是注意下面的情况，会自动删除 v=null的 kv
        map.computeIfPresent(9, (key, oldValue) -> null);  // 如果newValue 计算出来是 null（原来是null没关系），则会删除该 (key，value)
        System.out.println(map.containsKey(9));     // false

        System.out.println("======= computeIfAbsent (K key, Function<? super K, ? extends V> mappingFunction)");
        map.computeIfAbsent(23, num -> "val" + num);  //  key 没有在 Map中出现时进行操作
        System.out.println(map.containsKey(23));    // true
        map.computeIfAbsent(3, num -> "bam");        // 并不会修改
        System.out.println(map.get(3));


        System.out.println("=======  remove 还增加了 remove(k,v)，判断kv均匹配才删除 ");
        map.remove(0);  // 以前是只能根据一个 key 删除一个kv
        map.remove(3, "val3");  // 现在可以 default 删除一个 kv 均匹配的kv
        System.out.println(map.get(3));             // 还在，因为上面修改过val3
        map.remove(3, "3: val3");
        System.out.println(map.get(3));             // null

        System.out.println("======  其他一些有用的方法");
        //getOrDefault
        System.out.println(map.getOrDefault(42, "key 42 not found, this is default value"));  // 找不到key可以返回默认值，但是并不会添加到map中
        map.getOrDefault(42, "key 42 not found, this is default value");
        System.out.println(map.get(42));
        // merge
        map.merge(8, "...", (v, newValue) -> v.concat(newValue));  // merge 合并元素，查找key的v和第二个参数进行操作，结果作为新的v（如果键名不存在则插入）
        System.out.println(map.get(8));     // val8...
    }
}

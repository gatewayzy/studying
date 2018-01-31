package jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * Stream 接口 继承了BaseStream接口.
 * Created by dell on 2017/7/20.
 */
public class _08StreamForCollection {
    /**
     * Stream 用于一组元素上的操作，可进行中间操作然后返回Stream本身（以支持串行操作），或者直接返回指定类型的结果（stream将会关闭）
     * Stream 支持Collection 接口类的子类，如List、Set， 不支持Map接口类及其子类
     */

    static List<String> list;

    static {  // 写一个 static list 以方便测试 stream
        list = new ArrayList<>();
        list.add("ddd2");
        list.add("aaa2");
        list.add("bbb1");
        list.add("aaa1");
        list.add("bbb3");
        list.add("ccc");
        list.add("bbb2");
        list.add("ddd1");
    }

    // Stream 是针对Collection 集合接口类的改进；针对Map 接口类的改进有其他的方法
    public static void main(String[] args) {
        Stream stream = list.parallelStream();  // 支持并行Stream 和普通stream（串行）， 并行Stream在大任务量的情况下可以加速
        stream = list.stream();  //  简单情况下用普通stream就足够了，资源消耗小一些
        System.out.println("=========  经过简单filter结果如下，输出后该stream会关闭，要使用需重新获取");
        stream.filter(s -> s.toString().startsWith("a")).forEach(System.out::println);  // filter支持predicate函数式接口，属于中间操作，forEach属于最终操作

        // stream经过最终操作会关闭，再次使用需要重新获得
        System.out.println("===========  经过逆序sort、filter之后的结果为：");
        stream = list.stream();
        stream = stream.sorted(); // sorted 默认使用递增排序， 属于中间操作
        stream = stream.sorted((o1, o2) -> o2.toString().compareTo(o1.toString())); //  支持自定义comparator

        stream = stream.filter(s -> s.toString().contains("2"));
        stream.forEach(System.out::println);

        System.out.println("==========  注意：stream 并不会影响原来的 collection 中的数据");
        System.out.println(list);

        System.out.println("==========  stream 的 map 中间操作，");
        list.stream()
                .map(String::toUpperCase)   //  map 将集合中的元素按照指定的Function 进行转换，转换也会确定结果的类型
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);

        System.out.println("========= stream的match 匹配都是最终操作，比如查找集合里面anyMatch、allMatch、noneMatch等等");
        boolean anyStartsWithA = list.stream().anyMatch((s) -> s.startsWith("a"));  // Match属于最终操作，返回Predicate判断结果
        System.out.println(anyStartsWithA);      // true
        boolean allStartsWithA = list.stream().allMatch((s) -> s.startsWith("a"));
        System.out.println(allStartsWithA);      // false
        boolean noneStartsWithZ = list.stream().noneMatch((s) -> s.startsWith("z"));
        System.out.println(noneStartsWithZ);      // true

        System.out.println("========= stream的 count 属于最终操作，返回最终stream里面元素个数（long型）");
        System.out.println(list.stream().filter(s -> s.toString().startsWith("a")).count());

        System.out.println("========= stream的 reduce 规约 属于最终操作，用 BinaryOperator 将所有元素进行统一处理");
        Optional<String> reduced = list.stream().sorted().reduce((s1, s2) -> s1 + "#" + s2);  // BinaryOperator 就是对两个数进行操作
        reduced.ifPresent(System.out::println);

        System.out.println("=========  parallelStream 并行stream会在多线程中同时运行，串行stream只运行在一个线程中");
        int max = 1000000;
        List<String> values = new ArrayList<>(max);  // 创建一个非常大的string列表
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();  // 添加max 个 immutable universally unique identifier (UUID) (128 bits)
            values.add(uuid.toString());
        }

        // 试验 串行stream 和并行stream 的速度差： 分别对大列表进行排序，比较消耗的时间，这里所用时间基本差一倍
        long t0 = System.nanoTime();
        long count = values.stream().sorted().count();
        System.out.println("total size: " + count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential comparator took: %d ms", millis));

        long t01 = System.nanoTime();
        long count1 = values.parallelStream().sorted().count();
        System.out.println("total size: " + count1);
        long t11 = System.nanoTime();
        long millis1 = TimeUnit.NANOSECONDS.toMillis(t11 - t01);
        System.out.println(String.format("parallel comparator took: %d ms", millis1));
    }

}

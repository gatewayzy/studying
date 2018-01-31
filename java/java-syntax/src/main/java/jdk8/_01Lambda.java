package jdk8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * jdk8 特性之 lambda表达式
 * 参考：http://www.importnew.com/16436.html
 * Created by dell on 2017/7/19.
 */
public class _01Lambda {
    final int finalInt = 1;
    static int staticInt = 2;
    int ordinaryInt = 3;

    /**
     * lambda表达式目的就是让代码更加紧凑，常用于listener、thread、handler等函数式接口，lambda对应的就是其内部的那个抽象方法;
     * 用处之一：函数式接口 A a=lambda表达式，得到一个实现且实例的接口a
     *
     * @param args
     */
    public static void main(String[] args) {
        // 简单看一下lambda
        System.out.println("========= 快速示例 Lambda");
        new Thread(new Runnable() {
            public void run() {
                System.out.println("jdk7需要写成匿名类");
            }
        }).run();
        new Thread(() -> System.out.println("jdk8 的lambda，前面无参数传递进来")).run();

        // _01Lambda Syntax 语法
        // 1 基本形式是 参数->表达式， 如果参数是空则需要写成()，如果表达式有多行需要用{}包起来
        System.out.println("=========== lambda语法之：基本形式是 参数->表达式， 如果参数是空则需要写成()，如果表达式有多行需要用{}包起来");
        String[] datas = new String[]{"peng", "zhao", "li"};
        Arrays.sort(datas);
        Stream.of(datas).forEach(param -> System.out.println(param));  // 前面传递参数给后面表达式
        new Thread(() -> System.out.println("前面无参数传递给表达式，所以前面用()")).run();   //前面无参数使用()
        Arrays.asList(datas).forEach(x -> {
            System.out.print(x);  // 后面多行代码使用{}包起来
            System.out.println();
        });

        //2 java属于强类型语言，参数必须有类型。lambda推测参数类型类似于泛型处理
        System.out.println("=========== lambda语法之：参数类型可以自动推断，类似于泛型处理的机制");
        Arrays.sort(datas, (String v1, String v2) -> Integer.compare(v1.length(), v2.length()));
        Arrays.sort(datas, (v1, v2) -> Integer.compare(v1.length(), v2.length()));
        Stream.of(datas).forEach(v1 -> System.out.println(v1));

        // 3 表达式只有一条语句，可以省略{};和return
        System.out.println("=========== lambda语法之：如果表达式只有一句，可以将{};和return一起省略，否则都要带上");
        Arrays.stream(datas).map(name -> {
            return name.toUpperCase();
        }).collect(Collectors.toList());
        Arrays.stream(datas).map(name -> name.toUpperCase()).collect(Collectors.toList());  // 简化后的表达式

        // 4 支持Method Reference 方法引用
        System.out.println("=========== streamAPI也可以结合方法引用，Lambda表达式可以用方法引用实现");
        Arrays.stream(datas).map(String::toUpperCase).collect(Collectors.toList());
        Stream.of(datas).forEach(System.out::println);

        // 示例--以前的Comparator写成lambda匿名类
        System.out.println("========= 示例：Comparator函数式接口用lambda表达式实例一个对象");
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        // jdk8的lambda和方法引用
        Collections.sort(names, (o1, o2) -> o1.compareTo(o2));
        names.forEach(System.out::println);

        // lambda 表达式的作用域
        // 在lambda表达式中访问外层作用域和老版本的匿名对象中的方式很相似。
        // 你可以直接访问标记了final的外层局部变量，或者实例的字段以及静态变量。
        System.out.println("======== Lambda表达式的作用域");
        final int a = 4;
        int b = 5;
        _01Lambda aThis = new _01Lambda();
        new Thread(() -> {
            System.out.println("final 不可变：" + aThis.finalInt);
            aThis.staticInt = 22;  // lambda中可以改变一个对象的static和普通成员变量
            aThis.ordinaryInt = 33;
            System.out.println("lambda 中不能修改本地变量，在表达式范围内，本地变量只能是final或者隐性的具有final的语义");
            System.out.println("b连访问都不行，final a=" + a);
        }).start();
        b = 555;  // 在外部可以改变b，但是lambda里面连访问b都不行

    }


}

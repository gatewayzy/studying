package jdk8;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * jdk8 的重要接口
 * Created by dell on 2017/7/20.
 */
public class _06NewInterfaces {

    public static void main(String[] args) {
        /**
         * jdk8 中包含了大量函数式接口，新建或改造了很多重要接口
         * */
        viewPredicate();
        viewFunction();
        viewSupplier();
        viewConsumer();
        viewComparator();
    }

    static class Person {
        String name = "default-name";
        String gender;

        Person() {
        }

        Person(String name, String gender) {
            this.name = name;
            this.gender = gender;
        }
    }

    static void viewPredicate() {
        /** java.util.function.Predicate;
         * Predicate 函数式接口 抽象方法是boolean test(T t); 原本意图是返回泛型预测语句t的结果
         * */
        System.out.println("=========  Predicate 接口 ");
        Predicate<String> predicate = o -> o.length() > 3;  // 用lambda实现predicate的抽象方法，这里将功能限定为是否长度大于10
        System.out.println(predicate.test("123"));
        System.out.println(predicate.test("123456"));
        // Predicate还有几个default方法：与 或 异或xor、还有一个isEqual静态方法判断是否相等
        System.out.println(predicate.and(o -> o.length() <= 6).test("123456"));  // 将两个predicate进行与，然后再判断目标的结果
        System.out.println(predicate.and(o -> o.length() <= 6).test("123456789"));  // 将两个predicate进行与，然后再判断目标的结果
        System.out.println(Predicate.isEqual("java").test("java"));
        System.out.println(Predicate.isEqual("java").test("Java"));  // 接口中的静态方法可以快速生成是否与目标equals的判断语句
    }

    static void viewFunction() {
        /**java.util.function.Function;
         * Function 函数式接口 ，其抽象方法是 R apply(T t);  应用t函数，返回其结果r
         * function 的default方法有组合compose、andThen接下来。此外还有static方法identity，用于返回传入的参数
         * */
        System.out.println("=========  Function 接口");
        Function<String, String> toLowerCase = String::toLowerCase;  // 应用函数valueOf，返回其结果功能是将前面的参数通过函数转换为后面的参数
        System.out.println(toLowerCase.apply("ABCDE123xyzTT"));  //

        Function<String, char[]> toLowerThenToArr = toLowerCase.andThen(String::toCharArray); // 定义函数，将string用过string的函数，转化为char[]
        System.out.println("ABCDE123xyzTT".length());
        System.out.println(toLowerThenToArr.apply("ABCDE123xyzTT").length);  // 可以看出，addThen就是先后组合两个函数

        Function<String, String> toUpperCase = String::toUpperCase;
        Function<String, char[]> toArr = String::toCharArray;
        System.out.println(toArr.compose(toUpperCase).apply("ABCDE123xyzTT")); // compose组合的时候，后面的先运行，这里先toUpper再toArr
        System.out.println(toArr.compose(toUpperCase).apply("ABCDE123xyzTT").length);

        System.out.println(Function.identity().apply("ABCDE123xyzTT"));  // Function还有一个static方法identity，本质上可以用下面的实现
        Function<String, String> same = o -> o;  //  这种方式不仅会创建一个实例（原样返回的功能），还会创建一个独立的实现类  (参考 https://stackoverflow.com/questions/28032827/java-8-lambdas-function-identity-or-t-t)
        System.out.println(same.apply("ABCDE123xyzTT"));  // Function.identity() 功能上就是原样返回参数对象，但可以缩小内存开销
    }

    static void viewSupplier() {
        /**java.util.function.Supplier;
         * Supplier 函数式接口  只有一个get() 抽象方法, 由于get() 方法没有传入参数，所以不能传入lambda 参数，基本只能用 默认构造器
         * */
        System.out.println("======= Supplier 函数式接口 ");
        Supplier<Person> supplier = Person::new;   // 方法引用可以作为lambda表达式的一种实现形式
        supplier = () -> new Person();
        // supplier = (a,b) -> new Person(a,b); // supplier 不可以使用传参 构造器 作为 lambda
        Person a = supplier.get();   // 申请一个对象
        a.name = " person a";
        System.out.println(supplier.get().name + a.name);
    }

    static void viewConsumer() {
        /**java.util.function.Consumer;
         * Consumer 函数式接口  只有一个 accept 抽象方法，一个 addThen default方法
         * */
        System.out.println("======= Consumer 函数式接口 ");
        Consumer<Person> consumer = a -> {
            a.gender = "male?";
            System.out.println(a.name + a.gender);
        };
        consumer.accept(new Person());
    }

    static void viewComparator() {
        /** java.util.Comparator;
         * Comparator 函数式接口，是老接口改进而来  只有一个 compareTo 抽象方法，很多default方法和static方法
         * */
        System.out.println("======= Comparator 函数式接口 ");
        Comparator<Person> comparator = (p1, p2) -> p1.name.compareTo(p2.name);
        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");
        System.out.println(comparator.compare(p1, p2));
        System.out.println(comparator.reversed().compare(p1, p2));
    }
}

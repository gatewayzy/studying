package jdk8;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Created by dell on 2017/7/20.
 */
public class _07Optional {

    // 写一个静态类 方便Optional 操作是否为空或null
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

    public static void main(String[] args) {
        /**java.util.Optional;
         * Optional 是一个 final class  用于解决 NullPointerException 问题，jdk8中推荐返回 optional 代替 null
         * 一句话小结: 使用 Optional 时尽量不直接调用 Optional.get() 方法, Optional.isPresent() 更应该被视为一个私有方法,
         * 应依赖于其他像 Optional.orElse() , Optional.orElseGet() , Optional.map() 等这样的方法.
         * 在源码中 ifPresent、orElse , orElseGet , map 等方法都是调用isPresent 辅助判断是不是 value==null，一般不要直接使用isPresent
         */
        // 源码中，Optional其实是对一个 private final T value 的封装，是否为空的判断直接使用ifPresent、orElse 等方法
        System.out.println("======= Optional 函数式接口 ");
        Optional<Person> personPresent = Optional.of(new Person());
        Consumer<Person> consumer = a -> System.out.println("出现了（对象存在/不是空或者null），出现的名字是：" + a.name);
        // 可以用ifPresent和orElse进行逻辑控制：ifPresent(consumer)就是如果对象存在就运行后面的；orElse(new T)就是如果对象不存在就返回一个新的非空对象。
        personPresent.ifPresent(consumer);   // ifPresent 表示：如果出现了就运行后面的，如果是Empty或者null就不会运行后面，而是不处理。
        System.out.println("没有出现的时候，可调用orElse 返回新对象：" + personPresent.orElse(new Person("unknown", "unknown")).name);

        // Optional.empty() 是封装的是一个 new Optional(), 虽然它的 value是 null，但是这个Optional 容器不是null，不属于 present 状态
        personPresent = Optional.empty();
        personPresent.ifPresent(consumer);  // empty属于没有出现的情况，不运行后面的consumer
        System.out.println("没有出现的时候，返回新对象：" + personPresent.orElse(new Person("unknown", "unknown")).name);

        personPresent = Optional.ofNullable(null);  // Optional.of(T value) 中 不可以传入 null，想允许为null需要用ofNullable
        personPresent.ifPresent((a) -> System.err.println("person出现了，不是empty或者null"));  // 由于是null，不属于出现的情况，所以不运行consumer
        System.out.println("没有出现，调用orElse 返回新对象：" + personPresent.orElse(new Person("unknown", "unknown")).name); // 如果是 null 则返回内部 value ,否则返回指定的默认值

        // orElseGet 在 orElse 之上 支持 可以重用的 supplier，不必每次都写
        personPresent.ifPresent((a) -> System.err.println("person出现了，不是empty或者null"));
        System.out.println("没有出现，用supplier创建新对象：" + personPresent.orElseGet(Person::new).name);
        System.out.println("没有出现，用supplier创建新对象：" + personPresent.orElseGet(() -> new Person()).name);

        // map 最强大的地方是支持 多轮迭代，迭代过程中遇到空或null会直接跳到orElse结果
        System.out.println(personPresent.map(p -> p.name).orElse("对象是空或null，返回这个吧"));
        personPresent = Optional.of(new Person());
        System.out.println(personPresent.map(p -> p.name).map(name -> name.toUpperCase()).orElse("多轮迭代对象或者对象的name是空或null"));
        System.out.println(personPresent.map(p -> p.gender).map(g -> g.toUpperCase()).orElse("多轮迭代对象或者对象的name是空或null"));

    }
}

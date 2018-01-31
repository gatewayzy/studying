package jdk8;

/**
 * jdk8特性之  方法引用和构造函数引用
 * Created by dell on 2017/7/20.
 */
public class _05ConstructorReference {
    // 构造函数引用

    // 写一个含有多个构造函数的内部类
    static class Person {  // 在static main 中引用其构造函数，所以设置为static class
        String name;
        String gender;

        Person() {
        }

        Person(String name) {
            this.name = name;
        }

        Person(String name, String gender) {
            this.name = name;
            this.gender = gender;
        }
    }

    // 写一个对象工厂接口，这也是一个函数式接口
    interface PersonFactory<P extends Person> {
        P create(String name, String gender);
    }

    public static void main(String[] args) {
        PersonFactory<Person> factory = Person::new;  // 构造函数的引用用 类::new
        Person p1 = factory.create("Tom", "male");  // 其实还是将函数式接口中的抽象方法指定为Person::new而已
        System.out.println(p1.name + p1.gender);

        PersonFactory<Person> fac = (o1, o2) -> new Person(o2 + o2, o1 + o1); // 使用lambda表达式指定构造方法
        Person p2 = fac.create("zhang", "female");
        System.out.println(p2.name + p2.gender);
    }
}

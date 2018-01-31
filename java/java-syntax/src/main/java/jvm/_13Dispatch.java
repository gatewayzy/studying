package jvm;

/**
 * 方法调用有解析和分派两种方式，分派有静态、动态之分，也有单分派、多分派之分。
 * 解析就是 invokestatic、invokespecial 对应的非虚方法（以及非虚方法：final 方法），在类加载解析或第一次使用时调用到对应方法的直接引用。
 * 解析属于静态的，在编译期间就会确定下来对应的方法。非虚方法：static方法、类实例构造器、私有方法、父类方法、final方法都是解析调用的。
 * Created by dell on 2017/7/26.
 */
public class _13Dispatch {

    /**
     * 静态分派：典型应用是方法重载。方法重载的依据是参数的静态类型和数量，而不是实际类型
     */
    static abstract class Human {
        abstract void get();

        void put() {
            System.out.println("Human put");
        }
    }

    static class Man extends Human {
        @Override
        void get() {
            System.out.println("Man get");
        }

        @Override
        void put() {
            System.out.println("Man put");
        }
    }

    static class Woman extends Human {
        @Override
        void get() {
            System.out.println("Woman get");
        }

        @Override
        void put() {
            System.out.println("Woman put");
        }
    }

    public static class StaticPai {

        public void say(Human hum) {
            System.out.println("I am human...");
        }

        public void say(Man hum) {
            System.out.println("I am man---");
        }

        public void say(Woman hum) {
            System.out.println("I am woman****");
        }

        public static void main(String[] args) {
            // 静态分派应用--重载 overload
            System.out.println("============= 静态分派应用--重载 overload");
            Human man = new Man();  // 变量定义的时候就确定了静态类型，编译之后就不会改变，虽然使用的时候可以改变，但最终还是不能变的。
            Human woman = new Woman();
            StaticPai sp = new StaticPai();
            sp.say(man);  // 参数的实际类型是Human，所以重载到say(Human hum)
            sp.say(woman);// 参数的实际类型是Human，所以重载到say(Human hum)
            man = new Woman(); // 修改其实际类型为Woman
            sp.say(man); // 静态解析，静态属性仍是Human，在变量定义的时候就已经确定了,在编译期也确定下来了，无法改变
            sp.say((Woman) man); //使用的时候可以改变静态类型为Human，
            sp.say(man);  // 但是其静态类型仍是Human

            Woman woman1 = new Woman();
            sp.say(woman1);  // 变量定义的时候确定其静态类型为Woman，所以重载到say(Woman hum)

            // 动态分派应用--重写 overwrite
            System.out.println("============== 动态分派应用--重写 overwrite");
            Human man2 = new Man();
            Human woman2 = new Woman();
            man2.get();
            man2.put();
            woman2.get();
            woman2.put();
        }
    }
}

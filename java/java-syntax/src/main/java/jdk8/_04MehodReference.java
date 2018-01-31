package jdk8;

/**
 * jdk8特性之  方法引用和构造函数引用
 * Created by dell on 2017/7/20.
 */
public class _04MehodReference {

    //@FunctionalInterface  // 定义一个函数式接口
    interface Calcu {
        default double cal(int a) {  // 为接口添加一个普通的default方法，实现类不需要重写该方法
            return Math.sqrt(a);
        }

        default double pow(int a) {
            return Math.pow(a, 2);
        }

        void print(int a);

        static void show(int a) {   // 这是一个非抽象方法，需要指明static
            System.out.println("调用接口中的非抽象方法，a=" + a);
        }
    }


    // 写一个内部类（需要static），方便在下面展示方法引用
    static class Inner {
        static void prints(int a) {  // 由于在static中引用，所以需要该方法也是static的
            System.err.println("Inner::prints : " + a);
        }
    }

    /**
     * 函数引用Method reference使用关键字::
     */
    public static void main(String[] args) {
        System.out.println("========对自定义的函数式接口使用方法引用（替换掉lambda表达式）");
        Calcu c2 = (a) -> System.err.println(a);  // lambda表达式 实例化接口
        c2.print(12);
        // 由于lambda表达式对应函数式接口的抽象方法，所以可以结合方法引用替换lambda表达式
        // 方法引用是任何类基本都可以进行方法引用，但是lambda只能针对函数式接口
        Calcu calcu = Inner::prints;  //  方法引用  实例化接口
        calcu.print(13);

    }


}

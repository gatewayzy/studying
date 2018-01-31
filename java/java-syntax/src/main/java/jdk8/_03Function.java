package jdk8;

/** jdk8 特性之函数式编程
 * Created by dell on 2017/7/20.
 */
public class _03Function {

    // lambda表达式在系统中都对应一个类型，通常是接口类型。
    // 函数式接口是指抽象方法的个数为1的接口，每一个lambda表达式会匹配到这个抽象方法，从而解析lambda。
    // 所以 lambda表达式可看做一个抽象方法数为1的接口。
    // 而接口的default方法不是抽象方法，所以一个函数式接口就是：一个抽象方法+多个可选的非抽象（如default方法、static方法）
    // jdk8中将之前的一些Comparator、Runnable等接口都改造成了函数式接口（方法限制 + @FunctionalInterface 注解）

    /***
     * 比如这是一个函数式接口：只有一个抽象方法，和多个default默认方法。
     * 所以这个函数式接口是可以对应lambda表达式的，但是需要对该接口启用 @FunctionalInterface 注解(好像不用注解)
     * <b>总的来看，lambda表达式就是对应一个函数式接口，lambda表达式对应其抽象方法。
     * 实际上就是将lambda表达式传递到接口的唯一一个抽象方法中进行去抽象化，
     * 得到接口的一个匿名的子类实例，供lambda表达式外部调用</b>
     */
    //@FunctionalInterface
    interface Calcu {
        default double cal(int a) {  // 为接口添加一个普通的default方法，实现类不需要重写该方法
            return Math.sqrt(a);
        }

        default double pow(int a) {
            return Math.pow(a, 2);
        }

        void print(int a);
    }

    public static void main(String[] args) {
        Calcu c1 = new Calcu() {  // 实现接口的一个子类，需要实现其抽象方法
            @Override
            public void print(int a) {
                System.out.println(a);
            }
        };
        c1.print(9);
        System.out.println(c1.cal(9) + "\t" + c1.pow(9));

        System.out.println("========对自定义的函数式接口使用lambda表达式");
        Calcu c2 = (a)-> System.err.println(a) ;
        c2.print(12);
        Calcu c3 = System.out::print;
        c3.print(33);
    }


}

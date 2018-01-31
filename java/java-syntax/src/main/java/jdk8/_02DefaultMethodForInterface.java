package jdk8;

/**
 * jdk8特性之 方法拓展： 接口可以有一个default的非抽象方法
 * Created by dell on 2017/7/20.
 */
public class _02DefaultMethodForInterface {
    // 接口本身默认就是抽象的一种类，所以内部接口不需要加static（不像内部类）
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
        System.out.println(c2.pow(10));
    }
}

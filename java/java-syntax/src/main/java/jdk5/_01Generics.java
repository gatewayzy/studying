package jdk5;

/**
 * 泛型 http://www.weixueyuan.net/view/6321.html
 * Created by dell on 2017/7/19.
 */
public class _01Generics {
    /**
     * 泛型有泛型类、泛型接口、泛型方法，三者没有必要关系。泛型常见于框架、库的设计中。
     * 泛型本质上是参数化类型，类型是任意的，是经过传递的。但是不能传递基本类型，只能传递引用类型，但是基本数据会自动装箱为包装类型。
     * 自定义泛型用字母表示如T，V等，通配符型泛型用?表示。
     * 自定义泛型一般用 【extends 父类】限定本泛型类只能是包括父类在内的子类；
     * 通配符?泛型用【super 父类】限定或者【extends 父类】限定，<? super T>表示包括T在内的任何T的父类，<? extends T>表示包括T在内的任何T的子类
     *
     * @param args
     */
    public static void main(String[] args) {
        // 实例化泛型类
        Point<Integer, Integer> p1 = new Point<Integer, Integer>();
        p1.setX(10);
        p1.setY(20);
        p1.printPoint(p1.getX(), p1.getY());

        Point<Double, String> p2 = new Point();  // 后面的类型可以省略
        p2.setX(25.4);
        p2.setY("东京180度");
        p2.printPoint(p2.getX(), p2.getY());
    }


    // 定义泛型类
    static class Point<T1 extends Number, T2> implements Info<T1, T2> {
        T1 x;
        T2 y;

        public T1 getVar() {
            return this.x;
        }

        public T1 getX() {
            return x;
        }

        public void setX(T1 x) {
            this.x = x;
        }

        public T2 getY() {
            return y;
        }

        public void setY(T2 y) {
            this.y = y;
        }

        // 定义泛型方法
        public <T1, T2> void printPoint(T1 x, T2 y) {
            T1 m = x;
            T2 n = y;
            System.out.println("This point is：" + m + ", " + n);
        }
    }

    //定义泛型接口
    static interface Info<T1 extends Number, T2> {  // 泛型是支持限定可用类型的，比如这里只允许泛型类型是Number的子类
        public T1 getVar();
    }
}

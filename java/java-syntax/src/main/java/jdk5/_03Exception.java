package jdk5;

/**
 * Created by dell on 2017/9/1.
 */
public class _03Exception extends Exception {
    public _03Exception(String mes) {
        super(mes);// super()使用父类构造器
    }

    void printMes() {
        System.out.println(super.getMessage());//调用父类的方法获取message
    }

    public static void main(String[] args) {
        try {
            throw new _03Exception("出错啦");
        } catch (_03Exception e) {
            e.printMes();
        }
    }
}

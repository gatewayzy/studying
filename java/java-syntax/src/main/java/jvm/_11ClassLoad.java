package jvm;

/**
 * Created by dell on 2017/7/25.
 */
public class _11ClassLoad {

    static {
        i = 0;
//        System.out.println(i); //  由于i放在static块后面，所以只能赋值，不能访问，否则就是非法向前引用
    }

    static int i = 1;

    public static void main(String[] args) {
        // jvm的类加载机制使从低向上查找类是否已加载，已加载则无需加载，未加载则从顶向下尝试加载
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println("classLoader of this class: " + classLoader);  // application classloader
        System.out.println("parent classloader: " + classLoader.getParent());  // extension classloader
        System.out.println("grandparent classloader: " + classLoader.getParent().getParent());  // c++ 实现的 bootstrap classloader
    }

    /**
     * 定义自己的类加载器，需要继承ClassLoader，一般重写loadClass，不要使用findClass
     */
    class myClassLoader extends ClassLoader {
        @Override
        protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
            return super.loadClass(name, resolve);
        }
    }

}

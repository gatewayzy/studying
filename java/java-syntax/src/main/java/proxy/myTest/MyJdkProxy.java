package proxy.myTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Ps:类加载器
 * 在Proxy类中的newProxyInstance（）方法中需要一个ClassLoader类的实例，ClassLoader实际上对应的是类加载器，在Java中主要有一下三种类加载器;
 * Booststrap ClassLoader：此加载器采用C++编写，一般开发中是看不到的；
 * Extendsion ClassLoader：用来进行扩展类的加载，一般对应的是jre\lib\ext目录中的类;
 * AppClassLoader：(默认)加载classpath指定的类，是最常使用的是一种加载器。
 *
 */
public class MyJdkProxy implements InvocationHandler {

    private Object targetObject; // 相当于一个公用的瓶子，存放每次需要代理的目标对象

    @Override  // 重写构造函数的调用方法
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("===before===");
        Object obj = method.invoke(targetObject, args);
        System.out.println("===after===");
        return obj;
    }

    /**
     * 绑定委托对象并返回一个代理类
     *
     * @param target
     * @return
     */
    public Object bind(Object target) {
        this.targetObject = target;
        //利用反射机制确定构造函数、接口信息、调用方法，构造一个新对象放到目标空间
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);   //要绑定接口(这是一个缺陷，cglib弥补了这一缺陷)  
    }


}

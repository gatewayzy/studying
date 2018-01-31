package proxy.myTest;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLIB动态代理的构造工厂
 * Created by dell on 2017/7/17.
 */
public class MyCGLIBProxy implements MethodInterceptor {
    private Object targetObj; // 公共瓶子，存放需要用代理生成的目标对象

    public Object bind(Object o) {
        this.targetObj = o;  // 需要代理的目标放到公共瓶子中
        Enhancer enhancer = new Enhancer();  // 增强子
        enhancer.setSuperclass(o.getClass());
        enhancer.setCallback(this);
        Object obj = enhancer.create();
        return obj;  // 返回公共瓶子的引用
    }

    /**
     * 重写代理工厂的调用方法
     *
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("===before");
        Object obj = method.invoke(targetObj, objects);
        System.out.println("===after");
        return obj;
    }

}

package jdk5;

import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * jdk5提供了注解 java.lang.annotation 包
 * <p>写一个简单的spring的dispatcherServlet：定义自己的注解类MyAnnotation、Controller、RequestMapping、Service等等</p>
 * <p>dispatcherServlet自启动，并递归扫描所有的class，判断各个class是否含有Controller等注解，如果有就添加到RequestMapping、Bean等路由Map和BeanMap中</p>
 * <p>业务代码中，写一些类，使用Controller等注解</p>
 */
public class _02Annotation {
    /**
     * 使用@interface替换class表明这个class是个注解类。对于一个注解类的注解，称为元注解。
     * 元注解是指注解的注解。包括  @Retention @Target @Document @Inherited四种。
     * 对于@Retention(RetentionPolicy.SOURCE)   //注解仅存在于源码中，在class字节码文件中不包含
     * 对于@Retention(RetentionPolicy.CLASS)     // 默认的保留策略，注解会在class字节码文件中存在，但运行时无法获得，
     * 对于@Retention(RetentionPolicy.RUNTIME)  // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
     */
    //定义一个注解类，元注解设置为：Retention为runtime，Target默认为任意，Documented默认，Inherited默认
    @Retention(RetentionPolicy.RUNTIME)    // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
    @Target({ElementType.FIELD, ElementType.METHOD})
    //定义注解的目标作用范围字段、枚举的常量/方法ANNOTATION_TYPE/CONSTRUCTOR/LOCAL_VARIABLE/PACKAGE/PARAMETER/TYPE
    @Documented   //说明该注解将被包含在javadoc中
    public @interface MyAnnotation {
        String[] value() default "abc";
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Annotation2 {
        int id() default 1;
    }

    /**
     * 将注解类应用到一个类中，相当于业务类
     */
    @Annotation2(id = 100)
    public static class MyController {
        @MyAnnotation(value = {"a", "b"})
        public void execute() {
            System.out.println("method");
        }
    }

    /**
     * 使用java.lang.reflect 反射机制获取注解信息
     */
    public static void main(String[] args) throws Exception {
        MyController controller = new MyController();  //获取Class实例
        Method method = MyController.class.getMethod("execute", new Class[]{}); //获取需要处理的方法Method实例
        //判断该方法是否包含MyAnnotation注解
        if (method.isAnnotationPresent(MyAnnotation.class)) {
            //获取该方法的MyAnnotation注解实例
            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
            //执行该方法
            method.invoke(controller, new Object[]{});
            //获取myAnnotation
            String[] value = myAnnotation.value();
            System.out.println(value[0]);
        }
        //获取方法上的所有注解
        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        System.out.println("================================== 对一个类，判断其是否含有某个注解");
        Annotation[] annotation2 = MyController.class.getAnnotations();
        Class<MyController> myControllerClass = MyController.class;
        System.out.println(myControllerClass.isAnnotationPresent(Annotation2.class));
        for (Annotation annotation : annotation2) {
            System.out.println(annotation);
        }
    }

}

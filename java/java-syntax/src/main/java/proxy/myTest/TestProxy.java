package proxy.myTest;

/**
 * http://blog.csdn.net/voyage_mh1987/article/details/5755729
 * <p>
 * 动态代理
 * 与静态代理类对照的是动态代理类，动态代理类的字节码在程序运行时由Java反射机制动态生成
 * 无需程序员手工编写它的源代码。动态代理类不仅简化了编程工作，而且提高了软件系统的可扩展性
 * 因为Java 反射机制可以生成任意类型的动态代理类。java.lang.reflect 包中的Proxy类和InvocationHandler 接口提供了生成动态代理类的能力。
 */
public class TestProxy {
    public static void main(String[] args) {
        /**
         * 1. 生成一个jdk动态代理类
         * 2. 创建需要代理的代理对象
         * 3. 用代理类动态创建代理对象并返回给代理对象引用：用反射机制获取代理对象的构造函数，创建一个代理对象
         * 4. 使用代理对象使用接口方法
         */
        MyJdkProxy myJdkProxy = new MyJdkProxy();  // 创建一个jdk代理工厂
        Student aStudent = new Student();  // 创建需要代理的代理对象：需要继承接口
        Human human = (Human) myJdkProxy.bind(aStudent);  // 代理工厂动态生成代理对象，然后绑定给代理对象：利用反射机制、接口信息、构造方法
        human.identity();  // 使用接口进行访问，因为jdk代理是绑定接口的

        String readme = "JDK代理针对的是接口编程，接口编程时推荐；需要实现InvocationHandler；使用Proxy.newProxyInstance产生对象，对象要实现接口\n" +
                "CGLIB代理依赖于CGLib类库，目标类不一定要实现接口，代理生成的类实际上是生成一个子类，覆盖其方法，是一种继承";
        System.out.println(readme);

        /**
         * CGLib代理需要引入cglib包和asm包，且二者版本需要兼容，如cglib2.2和asm3.1
         * 1. 创建cglib代理工厂
         * 2. 分配一个目标代理实例
         * 3. 用工厂动态创建该实例
         * 4. 目标类可以没有接口或者有接口，其实都是继承目标类，重写目标类的方法
         */
        MyCGLIBProxy myCGLIBProxy = new MyCGLIBProxy();
        Teacher teacher = new Teacher();
        teacher = (Teacher) myCGLIBProxy.bind(teacher);
        teacher.show();
        aStudent = new Student();  // 创建需要代理的代理对象：需要继承接口
        human = (Human) myCGLIBProxy.bind(aStudent);  // 代理工厂动态生成代理对象，然后绑定给代理对象：利用反射机制、接口信息、构造方法
        human.identity();

    }

}

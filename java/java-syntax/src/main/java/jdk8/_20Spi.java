package jdk8;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.spi.CalendarDataProvider;

/** <b>SPI 不是 jdk8特性 </b>
 * spi 机制： SPI英文为Service Provider Interface单从字面可以理解为Service提供者接口。
 * 为了实现在模块装配的时候能不在程序里动态指明，这就需要一种服务发现机制。
 * java spi就是提供这样的一个机制：为某个接口寻找服务实现的机制。
 * 有点类似IOC的思想，就是将装配的控制权移到程序之外，在模块化设计中这个机制尤其重要。
 * Created by dell on 2017/7/20.
 */
public class _20Spi {

    /**
     * SPI机制的约定：
     * 1)         在META-INF/services/目录中创建以接口全限定名命名的文件该文件内容为Api具体实现类的全限定名
     * 2)         使用ServiceLoader类动态加载META-INF中的实现类
     * 3)         如SPI的实现类为Jar则需要放在主程序classPath中
     * 4)         Api具体实现类必须有一个不带参数的构造方法
     */
    public static void main(String[] args) {

        //  比如 日历、时间 等信息都在spi中，可以由本地提供商 进行实现
        Method[] methods = CalendarDataProvider.class.getDeclaredMethods();
        Arrays.asList(methods).forEach(o -> {
            System.out.println(o.getModifiers());
            System.out.println(o.getGenericReturnType());
            System.out.println(o.getName());
        });

        CalendarDataProvider.class.getDeclaredFields(); // 获取其类的成员变量
    }


}

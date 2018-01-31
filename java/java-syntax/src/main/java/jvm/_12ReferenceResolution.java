package jvm;

/**
 * 类加载过程有：加载、连接（验证、准备、解析）、初始化
 * 初始化：运行类的clinit() 方法，这个方法由编译器自动生成，合并了static的变量赋值、static静态代码块.
 * clinit是类构造器，与类的构造函数是不一样的，前者是类加载过程中，后者属于一个方法，放在class的属性集合中的一个方法，在创建对象时调用
 * Created by dell on 2017/7/25.
 */
public class _12ReferenceResolution {

    /**
     * 主动引用有5种，只有主动引用才能触发类的初始化：
     * 1. 遇到new、getStatic、putStatic、invokeStatic这4条字节码指令，如new实例、读取或设置一个类的静态字段（static字段、static final字段例外）、调用一个类的静态方法
     * 2. 使用java.lang.reflect包进行反射调用时，如果没有初始化，需要初始化目标类
     * 3. 初始化一个类时，如果其父类未初始化，先触发其父类的初始化。子接口或实现类初始化不需要父接口的初始化，但是如果调用了父接口的类变量则会初始化
     * 4. 虚拟机启动时，用户需指定一个要执行的主类含main（）方法，该主类会先初始化
     * 5. 使用jdk1.7的动态语言支持时，如果一个java.lang.invoke.MethodHandle实例的解析结果为
     * REF_getStatic、REF_putStatic、REF_invokeStatic的方法句柄，而这个方法句柄对应的类没有进行初始化，则需要触发其初始化
     */

    public static final int superFinal = -2;
    public static int superInt = 3;

    static {
        System.out.println("Super init...");
    }

    _12ReferenceResolution() {
        System.out.println("super constructor");
    }

    public static void main(String[] args) {
        /** 访问类的全局变量只涉及到类是否已经加载和初始化，是不会触发实例化的，都属于类加载阶段 */
        // 被引用类的static字段并未在编译期放入常量池，因此会初始化被引用类：触发一个类要先初始化父类，再初始化自身
//        System.out.println(SubClass.subString);
        // 被引用类的static字段并未在编译期放入常量池，因此会初始化被引用类：触发一个类要先初始化父类，再初始化自身
//        System.out.println(SubClass.subInt);
        // 被引用类的static final字段，在类加载的准备阶段就会直接赋值为指定值，可以正常访问，不会初始化被引用类，但是会初始化自身类运行main
//        System.out.println(SubClass.staticFinal);
        // 被引用类创建数组时，不会初始化被引用类，但是会初始化自身类运行main
//        SubClass[] subClassArr = new SubClass[3];

        /** 实例变量只能先实例化再访问。实例化才会调用构造器，从这开始已经属于类的执行机制 */
        SubClass subClass = new SubClass(); // 实例化调用，先调用被引用类的父类，再构造被引用类
        System.out.println(subClass.anInt); // 正常访问实例化对象
        System.out.println(subClass.aFinal); // 正常访问实例化对象

    }

    static class SubClass extends _12ReferenceResolution {
        // 类变量对类只有一份空间，随着类加载的准备阶段分配在方法区的常量池，对所有实例对象共有，又叫全局变量
        public static String subString = "aa";  // static变量，类变量，准备阶段分配为null，初始化阶段进行赋值
        public static int subInt = -3;  // static变量，类变量，准备阶段分配为0，初始化阶段进行赋值
        public static final int staticFinal = -1; // static final 构成ConstantValue，准备阶段直接分配为-1，不允许改变
        // 实例变量只能随着实例化之后随着对象放在java heap中
        public final int aFinal = -4;  // 属于实例变量，只能实例化之后访问，final保证其一旦实例就是-4，不能改变
        public int anInt = -5; // 属于实例变量，只能实例化之后访问

        static {
            System.out.println("SubClass init!");
        }

        SubClass() {
            System.out.println("subClass constructor");
        }
    }
}

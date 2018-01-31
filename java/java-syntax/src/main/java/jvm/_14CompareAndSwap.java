package jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * 使用反射机制使用CAS CompareAndSwap
 */
public class _14CompareAndSwap {
    private static Unsafe unsafe;

    static {
        try {
            // 通过反射获取rt.jar下的Unsafe类, getDeclaredField是可以获取一个类的所有字段. getField只能获取public字段
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            //Unsafe类提供了一个private static final Unsafe theUnsafe，可以用于反射
            field.setAccessible(true);
            // 在java的反射中,通过字段获取对象的字段值field.get(object),字段不是静态字段的话,要传入反射类的对象
            // 如果传null是会报错，如果字段是静态字段的话,传入任何对象都是可以的,包括null
            unsafe = (Unsafe) field.get(null);  // 获取Unsafe类的 private static final Unsafe theUnsafe 对象。
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Target {
        int intParam = 3;
        long longParam;
        String strParam;
        String StrParam2;
    }

    /**
     * compareAndSwapInt是通过反射根据字段偏移去修改对象的.
     * 可以看到int是4个字节的偏移量,long是4个字节的偏移量,string是4个字节的偏移量
     * 注意 Unsafe的对象不能直接new,要通过反射去获取.
     */
    public static void main(String[] args) throws Exception {
        Class targetClass = Target.class;
        Field[] fields = targetClass.getDeclaredFields();
        System.out.println("fieldName:fieldOffset");
        // 获取属性偏移量
        Arrays.asList(fields).forEach(field ->
                System.out.println(field.getName() + ":" + unsafe.objectFieldOffset(field)));
        Target target = new Target();
        Field intFiled = targetClass.getDeclaredField("intParam");
        int a = (Integer) intFiled.get(target); // 反射，field.get(obj)获取对象相应的field
        System.out.println("原始值是:" + a);
        //intParam的字段偏移是12 原始值是3 我们要改为10
        // CAS方法封装，对target进行内存偏移V旧值是否是3，是则更新为新值10，返回更新boolean
        System.out.println(unsafe.compareAndSwapInt(target, 12, 3, 10));
        int b = (Integer) intFiled.get(target);
        System.out.println("改变之后的值是:" + b);
        //这个时候已经改为10了,所以会返回false
        System.out.println(unsafe.compareAndSwapInt(target, 12, 3, 10));
        System.out.println(unsafe.compareAndSwapObject(target, 24, null, "5"));
    }
}

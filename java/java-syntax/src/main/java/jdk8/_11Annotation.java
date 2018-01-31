package jdk8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;

/**
 * jdk8 特性之  支持多重注解
 * Created by dell on 2017/7/21.
 */
public class _11Annotation {

    // 定义一个 Hints 包装类注解 用来存放 Hint 注解
    @interface Hints {
        Hint[] value();
    }

    // Java 8允许我们把同一个类型的注解使用多次，只需要给该注解标注一下@Repeatable即可。
    @Repeatable(Hints.class)
    @interface Hint {
        String value();
    }

    // 使用包装类当容器来存多个注解（老方法）
    @Hints({@Hint("hint1"), @Hint("hint2")})
    class PersonOld {
    }


    //使用多重注解（新方法）。在这里java编译器会隐性的帮你定义好@Hints注解，了解这一点有助于你用反射来获取这些信息
    @Hint("hint1")
    @Hint("hint2")
    class Person {
    }

    /**
     * 即便我们没有在Person类上定义@Hints注解，我们还是可以通过 getAnnotation(Hints.class) 来获取 @Hints注解。
     * 更加方便的方法是使用 getAnnotationsByType 可以直接获取到所有的@Hint注解。
     *
     * @param args
     */
    public static void main(String[] args) {
        Hint hint = Person.class.getAnnotation(Hint.class);
        System.out.println(hint);
        Hints hints1 = Person.class.getAnnotation(Hints.class);
        System.out.println(hints1);
        Hint[] hints2 = Person.class.getAnnotationsByType(Hint.class);
        System.out.println(hints2.length);

    }

    // 另外Java 8的注解还增加到两种新的target上了
    @Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
    @interface MyAnnotation {
    }

}

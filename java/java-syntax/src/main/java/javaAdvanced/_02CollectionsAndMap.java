package javaAdvanced;

import java.util.*;

/**
 * java 集合类框架
 * Created by dell on 2017/9/7.
 */
public class _02CollectionsAndMap {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3,5,6,7,8};
        System.out.println(Arrays.toString(arr));

        List<Integer> list = Arrays.asList(arr);

        Collections.shuffle(list);
        System.out.println(list);

        /** 主要有Collection接口和Map接口
         * Collection接口继承Iterable接口
         */
    }
}

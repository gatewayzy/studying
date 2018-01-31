package _programming.instance;

import java.util.HashSet;
import java.util.Set;

/**
 * 输入一个整数n，范围在10^18之内，要求用1,1,2,2,4,4,8,8，……进行拆分，输出可以拆分的方案数量
 * Created by dell on 2017/9/13.
 */
public class CoinDivide {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            solve(i);
        }
    }

    /**
     * 将所有硬币均为为两组，分别遍历出n=a+b时，a和b所使用的硬币分法，然后相加，去重。
     * 比如：6=1+5=2+4=3+3，那么1+5就是“1”+“101”=102，表示第一堆使用1，第二堆使用4和1，总体就是1个4和2个1.
     * 分成两堆之后，可以保证每个硬币数量只会是0/1/2，不会超限。最后对{102,022,110}进行去重
     * @param a
     * @return
     */
    private static long solve(long a) {
        Set<Long> set = new HashSet<>();
        for (long i = 0; i <= a / 2; i++) {
            set.add(add(i, a - i));
        }
        System.out.println(String.format("%d有%d种实现方法：",a,set.size()));
        set.forEach((t)-> System.out.println(t));
        return set.size();
    }


    // 数字转化为二进制字符串，然后对应位置相加
    static long add(long a, long b) {
        String aa = digitToString(a);
        String bb = digitToString(b);
        return Long.valueOf(aa) + Long.valueOf(bb);
    }

    static String digitToString(long a) {
        StringBuilder sb = new StringBuilder();
        long aa = a;
        while (true) {
            if (a <= 1){
                sb.append(a % 2);
                break;
            }
            sb.append(a % 2);
            a >>= 1;
        }
        //System.out.println(aa + " 二进制:: "+sb.reverse().toString());
        return sb.reverse().toString();
    }
}

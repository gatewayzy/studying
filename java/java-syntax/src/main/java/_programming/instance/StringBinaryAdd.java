package _programming.instance;

import java.util.Arrays;

/**
 * Binary Add:
 * 实现两个只有01 String的二进制加法：String Add(String a, String b)
 * 例如Add("10", "110") = "1000"
 */
public class StringBinaryAdd {
    public static void main(String[] args) {
        // write your code here
        //System.out.println("Hello World!");
        String a = "10";
        String b = "110";
        System.out.println(add(a, b));
        // 数组的复制
        int[] arr = {1, 2};
        int[] bArr = new int[5];
        System.arraycopy(arr, 0, bArr, 0, 2);
        //System.out.println(Arrays.toString(bArr));
    }

    static String add(String a, String b) {
        if (null == a || b == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        int minLen = Math.min(a.length(), b.length());
        int maxLen = Math.max(a.length(), b.length());
        int cnt = 0;
        int current = 0;
        for (int i = 0; i < maxLen; i++) {
            if (i < minLen) {
                current = a.charAt(i) + b.charAt(i) - '0' - '0' + cnt;
            } else {
                current = a.length() > b.length() ? a.charAt(i) : b.charAt(i);
                current = current - '0' + cnt;
            }
            if (current == 2) {
                cnt = 1;
                current = 0;
            }
            stringBuilder.append(current);
        }
        if (cnt == 1) {
            stringBuilder.append(cnt);
        }
        return stringBuilder.reverse().toString();
    }

}
package _programming.instance;

import java.util.*;

/**
 * 输入嵌套的括号，输出与其长度相等，最长公共子序列的长度
 * 最长公共子序列使用dp求解：dp[i][j] = 当前两个是否相等? dp[i-1][j-1] + 1 : max(dp[i][j-1], dp[i-1],[j])
 */
public class LongestCommonSubstr {
    static {
        System.out.println("(())()\n4");
    }

    /**
     * 要求子串与原串长度相等，又LCS最长，那么就：原串中不断调整一个字符的位置，可以保证lcs最长为原长-1，对这些子串验证是否合法，放入集合
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            String sSub1 = s.substring(0, i) + s.substring(i + 1);  // 去除i位置

            for (int j = 0; j < s.length() - 1; j++) {
                String candidate = sSub1.substring(0, j) + s.charAt(i) + sSub1.substring(j); // 将i 位置添加到各个位置
                // 候选项的 lcs 一定最长，但是需要验证候选项的合法性，比如)放在第一个位置
                int tmp = 0;
                for (int k = 0; k < candidate.length(); k++) {
                    tmp += candidate.charAt(k) == '(' ? 1 : -1;  // 利用括号成对出现，如果是)开头最后的验证会是负数
                    if (tmp < 0) {  // 候选项中 前面出现太多 )
                        break;
                    }
                }
                if (tmp >= 0) {  // 候选项合法有效
                    set.add(candidate);
                }
            }

        }
        System.out.println(set.size() - 1); // 不包括自身
        set.forEach((a) -> System.out.println(a));
        return;
    }

}

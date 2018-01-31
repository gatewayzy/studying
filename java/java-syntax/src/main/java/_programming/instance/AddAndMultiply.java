package _programming.instance;

import java.util.Scanner;

/**
 * 正整数a，b，aa，bb，对a和b同时使用++、*2，是不是可以转换到aa、bb？如果能，输出最短转换次数
 */
public class AddAndMultiply {
    static {
        System.out.println("10 20 22 42\n2");
    }

    static int a, b, aa, bb;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        aa = scanner.nextInt();
        bb = scanner.nextInt();
        solution();
    }

    /**
     * 目标只要能同时除以2，就先除以2，不能同时除以2就-1，如果
     * 乘以2和加上1在顺序上是可以等价的
     */
    static void solution() {
        int ret = 0;
        while (true) {
            if (aa == a && bb == b) {  // 可达性检验
                break;
            }
            if (aa < a || bb < b) { // 不可达性检验
                ret = -1;
                break;
            }
            if (aa % 2 != bb % 2) { // 奇偶不同，不管怎么-1，都会是奇偶不同，最终能转换就必须全是++操作
                ret += aa - a == bb - b ? aa - a : -1;
                break;
            }
            if (aa % 2 == 0) { // 都是偶数，先除以2，再循环
                ret++;
                aa /= 2;
                bb /= 2;
            } else {// 都是奇数，先减去1，再循环
                ret++;
                aa--;
                bb--;
            }
        }
        System.out.println(ret);
    }
}


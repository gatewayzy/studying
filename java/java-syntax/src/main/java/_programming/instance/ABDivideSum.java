package _programming.instance;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 博弈问题：a和b两个人分别选1或2个数，要求a开始选，问a选的数字的和是否能比b选的数字的和要大？
 */
public class ABDivideSum {
    static {
        System.out.println(" 4 9 4 6 10\ntrue");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in  );
        int n = in.nextInt();
        ArrayList l = new ArrayList();
        for (int i = 0; i < n; i++)
            l.add(in.nextInt());

        System.out.println(solve(n, l, 0, 0, 0));
    }

    public static boolean solve(int n, ArrayList l, int pos, int sa, int sb) {
        if (n - pos == 0) {
            if (sa <= sb)
                return false;
            else
                return true;
        } else if (n - pos == 1) {
            sa = sa + (int) l.get(pos);
            if (sa <= sb)
                return false;
            else
                return true;
        } else if (n - pos == 2) {
            sa = sa + (int) l.get(pos) + (int) l.get(pos + 1);
            if (sa <= sb)
                return false;
            else
                return true;
        } else if (n - pos == 3) {
            sa = sa + (int) l.get(pos) + (int) l.get(pos + 1);
            sb = sb + (int) l.get(pos + 2);
            if (sa <= sb)
                return false;
            else
                return true;
        } else if (n - pos >= 4) {
            return (solve(n, l, pos + 3, sa + (int) l.get(pos), sb + (int) l.get(pos + 1) + (int) l.get(pos + 2))
                    && solve(n, l, pos + 2, sa + (int) l.get(pos), sb + (int) l.get(pos + 1)))
                    || (solve(n, l, pos + 4, sa + (int) l.get(pos) + (int) l.get(pos + 1), sb + (int) l.get(pos + 2) + (int) l.get(pos + 3))
                    && solve(n, l, pos + 3, sa + (int) l.get(pos) + (int) l.get(pos + 1), sb + (int) l.get(pos + 2)));
        }
        return true;

    }
}

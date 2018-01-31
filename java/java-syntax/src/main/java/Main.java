import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> a = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        int i = 0, j = 0;
        while (scanner.hasNextLine()) {
            List<Integer> b = new ArrayList<>();
            a.add(b);
            while (true) {
                int in = scanner.nextInt();
                System.out.println(in);
                b.add(in);
            }
        }

        a.forEach(t->{
            System.out.println(t.toArray());
        });

    }

}

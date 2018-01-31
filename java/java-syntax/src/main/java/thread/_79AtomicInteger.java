package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by dell on 2017/9/7.
 */
public class _79AtomicInteger extends AtomicInteger {
    public static void main(String[] args) {

        new _79AtomicInteger().compareAndSet(0, 1);
    }
}

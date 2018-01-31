package jvm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger AtomicLong等封装了CAS的方法，封装为getAndSet()、compareAndSet()、accumulateAndGet()等原子性方法
 * 调用这些原子性方法
 * Created by dell on 2017/8/19.
 */
public class _15AtomicInteger {
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    static void increase() {
        atomicInteger.incrementAndGet();  // 调用AtomicInteger类的原子性方法进行原子性自增
        System.out.println(atomicInteger.getAndIncrement());
    }

    public static void main(String[] args) {
        int threadCount = 20;
        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    increase();
                }
            });
            threads[i].start();
        }

//        while (Thread.activeCount() > 1) {
//            Thread.yield();
//        }
        System.out.println(atomicInteger);

    }
}

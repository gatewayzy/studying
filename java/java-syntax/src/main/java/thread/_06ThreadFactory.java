package thread;

import java.util.concurrent.ThreadFactory;

/**
 * Created by dell on 2017/9/13.
 */
public class _06ThreadFactory {
    static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println("task：" + Thread.currentThread().getId());
        }
    }

    /**
     * ThreadFactory 进行 线程封装
     */
    static class MyFactory implements ThreadFactory{
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r);
        }
    }
    public static void main(String[] args) {
        Thread t = new MyFactory().newThread(new Task());
        t.start();
    }
}

package thread;


/**
 * Created by dell on 2017/8/13.
 */
public class _01RunnableAndThread {
    static class MyThread extends Thread {
        private int ticket = 5;

        public void run() {
            for (int i = 0; i < 10; i++) {
                if (ticket > 0) {
                    System.out.println(currentThread().getName() + Thread.currentThread().getId()+" - " +Thread.currentThread().getPriority()+ " : ticket = " + ticket--);
                }
            }
        }
    }

    static class MyRunnable implements Runnable {
        private int ticket = 5;

        public void run() {
            for (int i = 0; i < 10; i++) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId()+" - "+Thread.currentThread().getPriority() + "  >>  ticket = " + ticket--);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        System.out.println("创建3个不同的线程，各个线程分别有5张票在卖，输出顺序不同");
        Thread t1 =new MyThread();t1.start();
        t1.join();    //  一个线程使用join之后，当前线程要等到t1执行完之后才能继续执行
        System.out.println("t1 已经卖完了");
        new MyThread().start();
        new MyThread().start();

        System.out.println("创建3个不同的线程，卖票卖的是同一个Runnable对象的5张票，输出顺序不同");
        MyRunnable my = new MyRunnable();
        Thread tt1 = new Thread(my);tt1.start();
        Thread tt2 = new Thread(my);tt2.start();
        Thread tt3 = new Thread(my);tt3.start();
        Thread.yield();  // 当前线程使用Thread.yield()，让同等级的线程优先执行完再继续自己。一般不会使用，效果不是很理想。
        System.out.println("所有线程运行完毕");
    }

}

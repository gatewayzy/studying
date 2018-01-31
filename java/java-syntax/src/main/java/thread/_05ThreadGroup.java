package thread;

/**
 * Created by dell on 2017/9/13.
 */
public class _05ThreadGroup {
    static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println("task：" + Thread.currentThread().getId());
        }
    }
    public static void main(String[] args) {
        // 创建线程组
        ThreadGroup threadGroup = new ThreadGroup("group1");
        for (int i = 0; i < 5; i++) {
            new Thread(threadGroup,new Task()).start();
        }
        System.out.println("============= 使用 enumerate 获取线程组包含的线程列表");
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for (int i = 0; i < threadGroup.activeCount(); i++) {
            System.out.println(threads[i].getId());
        }

    }

}

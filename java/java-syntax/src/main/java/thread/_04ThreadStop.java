package thread;

/**
 * 对于Thread启动的线程，关闭方式可以为：
 1 用一个static volatile变量控制
 2 设置线程的demon属性为true
 3 使用deprecated 的stop() destroy()方法
 * Created by dell on 2017/8/19.
 */
public class _04ThreadStop {
    public static volatile boolean flag = true;

    public static void main(String[] args) throws Exception {
        Thread t = new Thread() {
            @Override
            public void run() {
                int i = 0;
                while (flag) {
                    i++;
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
//                        break;
                    }
                }
            }
        };
//        t.setDaemon(true); //这个是可以的，一旦主线程结束，daemon线程自动退出
        t.start();
        Thread.sleep(2000);
//        t.interrupt();   //这个要配合catch中的break
//        flag=false;      //这个是可以的，volatile非常适合这种一次性变化
//        t.destroy();     //这个要配合catch中的break @deprecated
//        t.stop();        //这个是可以的 @deprecated
    }
}

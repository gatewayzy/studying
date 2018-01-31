package IOAndNetty;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

/**
 * Created by dell on 2017/9/15.
 */
public class _04AIOServer {
    public static void main(String[] args) throws Exception {
        System.out.println("启动服务器......");

        AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(InetAddress.getLoopbackAddress(), 8080));
        System.out.println("服务器正在监听：" + serverSocketChannel.getLocalAddress());
        //new Thread(serverSocketChannel, "AIO-server-001").start();
    }
//    CountDownLatch countDownLatch = new CountDownLatch(1);  // 使用并发辅助类，防止服务器运行结束后退出
//        serverSocketChannel.accept(attach, handler);
//            countDownLatch.await(); // 允许线程阻塞


}




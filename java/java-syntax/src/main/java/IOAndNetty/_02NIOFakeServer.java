package IOAndNetty;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 基于BIO实现 【伪NIO】，server接收到的请求使用线程池处理，避免每次都使用新的线程处理一个请求.
 * 伪NIO是基于BIO，如果一个线程长时间阻塞，会阻塞在队列中。
 * Created by dell on 2017/9/13.
 */
public class _02NIOFakeServer {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);  // Executors 建议使用固定大小的线程池，自动扩容的线程池可控性低

        ServerSocket serverSocket = new ServerSocket(8080,50,InetAddress.getLoopbackAddress());
        System.out.println("===== 服务器监听信息为：" + serverSocket.getInetAddress() + serverSocket.getLocalPort());
        Socket socket = null;
        while (true) {
            socket = serverSocket.accept(); // 阻塞等待，ServerSocket可以设置超时
            executorService.execute(new TaskRun(socket));
        }
    }

    static class TaskRun implements Runnable {
        private Socket socket;

        public TaskRun(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // 获取输入流，并读取内容
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                System.out.println(dataInputStream.readUTF());

                // 获取输出流，向client发送消息
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF(String.format("【msg from server：%s】client你好~~", socket.getLocalAddress().toString()));
            } catch (Exception e) {

            }
        }
    }

}

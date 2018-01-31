package IOAndNetty;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/** 属于传统的BIO模型，每次accept一个客户请求，就新建一个线程处理这个socket
 * BIO的缺点就是系统随着用户请求的增多，需要线性增加线程和资源。java1.4才开始支持NIO，以及NIO2.0。
 * 对BIO进行改进：使用伪NIO，即使用线程池如Executors框架，处理socket请求（线程池采用阻塞队列，如果一个socket的IO处理太慢，会导致队列处理缓慢）。
 * Created by dell on 2017/9/7.
 */
public class _01BIOServerSocket {

    public static void main(String[] args) throws Exception {
        InetAddress inetAddress = InetAddress.getLoopbackAddress();
        ServerSocket serverSocket = new ServerSocket(8080, 50, inetAddress);
        serverSocket.setSoTimeout(10000);  // 不设置的话会一直阻塞等待连接，这里设置超时关闭
        System.out.println("=== serverSocket 需要一直处于监听状态：");
        System.out.println(serverSocket.getInetAddress() + "\t" + serverSocket.getLocalPort());
        while (true) {
            try {
                // 默认阻塞等待连接，如果用setSoTimeout设置超时限制，必须在时限内收到连接请求，否则超时异常
                Socket socket = serverSocket.accept();
                new Thread(() -> {
                    try {
                        // 获取输入流，并读取内容
                        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                        System.out.println(dataInputStream.readUTF());

                        // 获取输出流，向client发送消息
                        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                        dataOutputStream.writeUTF(String.format("【msg from server：%s】client你好~~", socket.getLocalAddress().toString()));

                        // 关闭资源
                        socket.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).run();
            } catch (IOException e) {
                System.err.println("Accept timed out. 时限内没有收到连接请求...");
            }
        } // end of while
        // serverSocket.close();
    }
}

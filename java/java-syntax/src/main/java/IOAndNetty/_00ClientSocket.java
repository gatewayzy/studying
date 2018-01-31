package IOAndNetty;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by dell on 2017/9/7.
 */
public class _00ClientSocket {
    static int cnt = 5;
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < cnt; i++) {
            // 启动 多个 客户端线程
            new Thread(() -> {
                try {
                    // 设置要连接的服务器的ip、port
                    int serverPort = 8080;
                    InetAddress inetAddress = InetAddress.getLoopbackAddress();
                    System.out.println("===准备连接服务器，服务器信息为：");
                    System.out.println(inetAddress.getHostAddress() + "\t" + serverPort);
                    // 建立一个client的socket，一般不设置client使用的ip、端口号，会自动封装
                    Socket socket = new Socket(inetAddress, serverPort);  // 默认使用stream类型，TCP。如果连接失败会立即抛出异常
                    System.out.println("=== Client使用的socket信息为：");
                    System.out.println(socket.getLocalAddress() + "\t" + socket.getLocalPort());


                    System.out.println("===连接服务器成功，服务器地址为：" + socket.getRemoteSocketAddress());
                    // 获取输出流，并向server发送数据
                    OutputStream outputStream = socket.getOutputStream();
                    DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                    dataOutputStream.writeUTF(String.format("【msg from %s】Server你好，我是client %d", socket.getLocalAddress().toString(),cnt--));
                    // 获取输入流，读取server的数据
                    InputStream inputStream = socket.getInputStream();
                    DataInputStream dataInputStream = new DataInputStream(inputStream);
                    System.out.println(dataInputStream.readUTF());

                    // 关闭资源
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

}

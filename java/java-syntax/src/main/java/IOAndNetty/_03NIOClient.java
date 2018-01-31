package IOAndNetty;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by dell on 2017/9/15.
 */
public class _03NIOClient {
    static int cnt = 5;
    volatile static boolean stop = false;

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < cnt; i++) {
            new Thread(() -> {
                try {
                    // 客户端也要使用NIO
                    Selector selector = Selector.open();
                    SocketChannel socketChannel = SocketChannel.open();

                    // socketChannel 配置
                    socketChannel.configureBlocking(false);

                    // 连接服务器
                    boolean established = socketChannel.connect(new InetSocketAddress(InetAddress.getLoopbackAddress(), 8080));
                    if (established) {
                        // 已经建立好连接，selector监听read事件
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    } else {
                        // 如果没有建立好连接，就注册为连接，selector监听连接事件
                        socketChannel.register(selector, SelectionKey.OP_CONNECT);
                    }

                    while (true) {
                        selector.select(1000);  // 定时1s使用selector进行轮询
                        Set<SelectionKey> selectionKeys = selector.selectedKeys();
                        //selectionKeys.forEach((key) -> handleSelectionKey(selector, key));
                        SelectionKey key = null;
                        Iterator<SelectionKey> it = selectionKeys.iterator();
                        while (it.hasNext()) {
                            key = it.next();
                            it.remove(); // selector的不一样，必须删除？？
                            handleSelectionKey(selector, key);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

    private static void handleSelectionKey(Selector selector, SelectionKey key) {
        // 对每个就绪的channel进行处理
        try {
            if (key.isValid()) {
                SocketChannel socketChannel = (SocketChannel) key.channel();
                // channel连接时，进行写数据
                if (key.isConnectable()) {
                    if (socketChannel.finishConnect()) {
                        socketChannel.register(selector, SelectionKey.OP_READ); // 监听读就绪，进行写数据
                        // 向服务器写数据
                        ByteBuffer writeBuffer = ByteBuffer.allocate(1024); // 请求1M缓存
                        byte[] send = String.format("【msg from %s】Server你好，我是client %d", socketChannel.getLocalAddress(), cnt--).getBytes("UTF-8");
                        writeBuffer.put(send);
                        writeBuffer.flip();
                        socketChannel.write(writeBuffer);
                        if (!writeBuffer.hasRemaining()) {
                            System.out.println("客户端发送完毕，没有遇到‘半包写’");
                        }
                    }
                }
                // 然后读数据
                if (key.isReadable()) {
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024); // 请求1M缓存
                    int readSize = socketChannel.read(readBuffer);  //先检查连接状态
                    if (readSize < 0) { // 对方已关闭连接，直接关闭自身的连接
                        key.cancel(); //取消此channel的监听
                        socketChannel.close();
                    } else if (readSize > 0) {
                        readBuffer.flip();
                        byte[] read = new byte[readBuffer.remaining()];
                        readBuffer.get(read);
                        System.out.println(new String(read, "UTF-8"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("服务器已经断开？？？");
            stop = true;
        }
    }
}

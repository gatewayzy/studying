package IOAndNetty;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO使用的是Buffer、Channel、Selector(epoll)。
 * Buffer缓冲区进行数据读写，
 * Channel通道是双向的，不像流是单向的分为输入流和输出流。
 * Selector实现多路复用，不断轮询注册在其上的Channel，对发生读/写事件的channel一起进行操作；channel对应的是连接，selector负责管理这些连接
 * Created by dell on 2017/9/13.
 */
public class _03NIOServer {
    volatile static boolean stop = false;

    public static void main(String[] args) throws Exception {
        // 服务器使用Selector对ServerSocketChannel进行监听
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 对SocketChannel进行配置
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(InetAddress.getLoopbackAddress(), 8080), 1024);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);  // 注册accept事件

        System.out.println(String.format("服务器正在监听：%s %d", serverSocketChannel.getLocalAddress(), serverSocketChannel.socket().getLocalPort()));

        while (!stop) {
            // 利用selector轮询channel，将就绪的channel进行处理
            selector.select(1000); // 等待channel就绪，selector每1s唤醒一次
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            // 对每个就绪的channel进行处理
//           selectionKeys.forEach((key) -> handleSelectionKey(selector, key));
            SelectionKey key = null;
            Iterator<SelectionKey> it = selectionKeys.iterator();
            while (it.hasNext()) {
                key = it.next();
                it.remove();
                handleSelectionKey(selector, key);
            }
        }
    }

    /**
     * 对每一个 SelectionKey 所标识的 用户Channel进行处理
     *
     * @param selector
     * @param key
     */
    private static void handleSelectionKey(Selector selector, SelectionKey key) {
        try {
            if (key.isValid()) {
                // 如果channel是可接受的，说明是获得的新的请求连接，将请求注册到selector
                if (key.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                    //新连接在读取key对应的channel，应该是ServerSocketChannel，然后accept之后才是SocketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }
                // 如果channel是可读的，就进行业务处理
                if (key.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();  // 读取key对应的channel
                    if (socketChannel.isConnected()) {
                        System.out.println("channel 状态：" + socketChannel.isConnected() + socketChannel.isOpen() + socketChannel.isBlocking());
                    }
                    // 先要确定buffer的状态
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                    int readSize = socketChannel.read(readBuffer); // read设置为非阻塞，返回值可能是0：未读到数据，-1和正数
                    if (readSize < 0) { //-1：链路已关闭，需要关闭链接
                        key.cancel();
                        socketChannel.close();
                    } else if (readSize > 0) {
                        // 将数据从buffer中拷贝出来进行处理，不能在buffer中直接处理
                        readBuffer.flip(); // 缓冲区进行偏移：limit设置为position，position设置为0，为后续读取做准备
                        byte[] bytes = new byte[readBuffer.remaining()];  // 将buffer中数据都读取出来
                        readBuffer.get(bytes);
                        System.out.println("===== 服务器接收到：\n" + new String(bytes, "UTF-8"));

                        // 读取到用户数据之后，向用户写数据。虽然buffer是双向的/无向的，但是也不能业务覆盖
                        byte[] res = "【msg from server：%s】client你好~~".getBytes();
                        ByteBuffer writeBuffer = ByteBuffer.allocate(res.length);
                        writeBuffer.put(res); // put也是非阻塞的，一次可能发不完，出现“写半包”问题，要用hasRemain()进行判断续发，略
                        writeBuffer.flip();
                        socketChannel.write(writeBuffer);
                    }

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("一个客户端已经断开？？？");
            stop = true;
        }
    }


}

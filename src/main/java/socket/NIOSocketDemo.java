package socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author admin
 * @date 2020/4/5 16:02
 */
public class NIOSocketDemo {

    /**
     * 通道选择器
     */
    private Selector selector;

    /**
     * 初始化服务端
     * @param port
     */
    public void initServer(int port){
        try {
            ServerSocketChannel channel = ServerSocketChannel.open();
            //非阻塞
            channel.configureBlocking(false);
            ServerSocket socket = channel.socket();
            socket.bind(new InetSocketAddress(port));
            this.selector = Selector.open();

            channel.register(selector,SelectionKey.OP_ACCEPT);
            System.out.println("服务已启动...");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 轮询监听Selector
     */
    public void listenSelector() throws IOException {
        while (true){
            //等待客户连接，select模型，多路复用
            int select = selector.select();
            System.out.println("新客户端连接上来了...");
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey next = iterator.next();
                iterator.remove();
                handler(next);

            }


        }
    }

    private void handler(SelectionKey selectionKey) throws IOException {
        if (selectionKey.isAcceptable()) {
            //处理客户端连接请求事件
            ServerSocketChannel channel = (ServerSocketChannel)selectionKey.channel();
            SocketChannel socketChannel = channel.accept();
            socketChannel.configureBlocking(false);
            //接收客户端发送的信息，并给通道设置读的权限
            socketChannel.register(selector,SelectionKey.OP_READ);

        }else if(selectionKey.isReadable()){
            //处理读的事件
            SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int read = socketChannel.read(buffer);
            if(read>0){
                String msg = new String(buffer.array(),"gbk").trim();
                System.out.println("接收到的消息是:"+msg);
            }else {
                System.out.println("客户端关闭...");
                selectionKey.cancel();
            }

        }
    }

    public static void main(String[] args) throws IOException {
        NIOSocketDemo demo = new NIOSocketDemo();
        demo.initServer(8888);
        demo.listenSelector();

    }

}

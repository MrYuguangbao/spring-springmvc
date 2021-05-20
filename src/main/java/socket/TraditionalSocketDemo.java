package socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author admin
 * @date 2020/4/5 15:42
 */
public class TraditionalSocketDemo {

    public static void main(String[] args) throws IOException {
        ExecutorService service = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(7777);
        System.out.println("socket服务端启动...");
        while (true){
            Socket socket = serverSocket.accept();
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("客户端连接上来...");
                    try {
                        InputStream inputStream = socket.getInputStream();
                        byte[] bytes = new byte[1024];
                        while (true){
                            int read = inputStream.read(bytes);
                            if (read != -1){
                                String data = new String(bytes,0,read,"gbk");
                                System.out.println(data);
                            }else {
                                break;
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            service.shutdown();
        }



    }


}

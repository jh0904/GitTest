package nio2;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * nio2
 *
 * @author jh
 * @date 2018/7/8 16:22
 * description:NIO完成一个阻塞式网络通信并实现反馈。
 */
public class BlockNIOTest2 {
    @Test
    public void client() throws IOException {
        SocketChannel sChannel = SocketChannel.open (new InetSocketAddress ("127.0.0.1", 9898));

        FileChannel inChannel = FileChannel.open (Paths.get ("aa.jpg"), StandardOpenOption.READ);

        ByteBuffer buf = ByteBuffer.allocate (1024);
        while (inChannel.read (buf) != -1) {
            buf.flip ();
            sChannel.write (buf);
            buf.clear ();
        }

        sChannel.shutdownOutput ();


        //接受服务端反馈
        int len = 0;
        while ((len = sChannel.read (buf)) > 0) {
            buf.flip ();
            System.out.println (new String (buf.array (), 0, len));
            buf.clear ();
        }
        inChannel.close ();
        sChannel.close ();

    }

    @Test
    public void server() throws IOException {
//1.获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open ();

        FileChannel outChannel = FileChannel.open (Paths.get ("C:\\Users\\jh\\GitTest\\GitTest1\\src\\nio2\\test2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        //2.绑定端口
        ssChannel.bind (new InetSocketAddress (9898));
        //3.获取客户端连接的通道
        SocketChannel sChannel = ssChannel.accept ();
        //4.分配指定大小缓冲区
        ByteBuffer buf = ByteBuffer.allocate (1024);
        //5.接受客户端的数据，并保存到本地
        while (sChannel.read (buf) != -1) {
            buf.flip ();
            outChannel.write (buf);
            buf.clear ();
        }
        //6.发送反馈给客户端
        buf.put ("服务端接收数据成功".getBytes ());
        buf.flip ();
        sChannel.write (buf);

        //7.关闭通道
        sChannel.close ();
        outChannel.close ();
        ssChannel.close ();
    }
}

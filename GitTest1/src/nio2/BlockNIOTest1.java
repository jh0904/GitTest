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
 * @date 2018/7/8 15:51
 * description:用NIO实现一个简单的通讯。阻塞式IO
 */
public class BlockNIOTest1 {
    @Test
    public void cient() throws IOException {
        //1.获取通道
        SocketChannel sChannel = SocketChannel.open (new InetSocketAddress ("127.0.0.1", 9898));

        FileChannel inChannel = FileChannel.open (Paths.get ("aa.jpg"), StandardOpenOption.READ);
        //2.分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate (1024);
        //3.读取本地文件，并发送到服务器端
        while (inChannel.read (buf) != -1) {
            buf.flip ();
            sChannel.write (buf);
            buf.clear ();
        }
        //4。关闭通道
        inChannel.close ();
        sChannel.close ();
    }

    @Test
    public void server() throws IOException {
        //1.获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open ();

        FileChannel outChannel = FileChannel.open (Paths.get ("C:\\Users\\jh\\GitTest\\GitTest1\\src\\nio2\\2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

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
        //6.关闭通道
        sChannel.close ();
        outChannel.close ();
        ssChannel.close ();

    }

}

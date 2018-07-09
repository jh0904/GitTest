package nio2;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * nio2
 *
 * @author jh
 * @date 2018/7/9 22:00
 * description:
 */
public class PiepTest {
    @Test
    public void test1() throws IOException {
        //获取通道
        Pipe pipe = Pipe.open ();
        //将缓冲区中的数据写入通道
        ByteBuffer buf = ByteBuffer.allocate (1024);
        Pipe.SinkChannel sinkChannel = pipe.sink ();
        buf.put ("通过单向管道发送数据".getBytes ());
        buf.flip ();
        sinkChannel.write (buf);
        //读取缓冲区中的数据
        Pipe.SourceChannel sourceChannel = pipe.source ();
        sourceChannel.read (buf);
        buf.flip ();
        System.out.println (new String (buf.array (), 0, buf.limit ()));

        sourceChannel.close ();
        sinkChannel.close ();
    }
}

package cn.net.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.SocketHandler;

/**
 * cn.net.TCP
 *
 * @author jh
 * @date 2018/7/5 16:16
 * description: TCP实现简单交互
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket ("10.10.10.1", 8888);

        OutputStream os = s.getOutputStream ();
        os.write ("hello".getBytes ());
        s.close ();
    }
}

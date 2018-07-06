package cn.net.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * cn.net.TCP
 *
 * @author jh
 * @date 2018/7/5 17:06
 * description: TCP实现交互，并且实现接受数据并且反馈。
 */
public class ClientDemo1 {

    public static void main(String[] args) throws IOException {
        Socket s = new Socket ("10.10.10.1", 9999);

        OutputStream os = s.getOutputStream ();
        os.write ("今天肚子疼".getBytes ());

        InputStream is = s.getInputStream ();
        byte[] bb = new byte[1024];
        int read = is.read (bb);
        String s1 = new String (bb, 0, read);
        System.out.println ("client--->"+s1);

        s.close ();

    }
}

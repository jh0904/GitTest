package cn.net.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * cn.net.TCP
 *
 * @author jh
 * @date 2018/7/5 17:03
 * description:
 */
public class ServerDemo1 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket (9999);
        //阻塞
        Socket s = ss.accept ();

        InputStream is = s.getInputStream ();

        byte[] bb = new byte[1024];
        int read = is.read (bb);
        String s1 = new String (bb, 0, read);
        System.out.println ("server--->"+s1);

        OutputStream os = s.getOutputStream ();
        os.write ("数据已收到".getBytes ());
        s.close ();
    }
}

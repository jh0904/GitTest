package cn.net.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * cn.net.TCP
 *
 * @author jh
 * @date 2018/7/5 16:42
 * description:
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket (8888);

        Socket s = ss.accept ();

        InputStream is = s.getInputStream ();
        byte[] buf = new byte[1024];
        int read = is.read (buf);
        String hostAddress = s.getInetAddress ().getHostName ();
        System.out.println (hostAddress);
        String s1 = new String (buf, 0, read);
        System.out.println (s1);

        s.close ();
    }
}

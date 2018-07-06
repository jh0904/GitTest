package cn.net.TCP;

import java.io.*;
import java.net.Socket;

/**
 * cn.net.TCP
 *
 * @author jh
 * @date 2018/7/5 23:45
 * description:
 */
public class ClientDemo3 {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket ("10.10.10.01", 12345);

        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));

        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (s.getOutputStream ()));

        String line = null;
        while ((line = br.readLine ()) != null) {
            if ("over".equals (line)) {
                break;
            }
            bw.write (line);
            bw.newLine ();
            bw.flush ();
        }

        s.close ();
    }
}

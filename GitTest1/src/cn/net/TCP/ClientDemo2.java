package cn.net.TCP;

import java.io.*;
import java.net.Socket;

/**
 * cn.net.TCP
 *
 * @author jh
 * @date 2018/7/5 17:06
 * description:键盘输入交互，一直传输
 */
public class ClientDemo2 {

    public static void main(String[] args) throws IOException {
        Socket s = new Socket ("10.10.10.1", 11111);
        //输入流
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        //socket传输流
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (s.getOutputStream ()));

        String str=null;
        while ((str = br.readLine ()) != null) {

            if ("886".equals (str)) {
                break;
            }
            bw.write (str);
            bw.newLine ();
            bw.flush ();
        }
        s.close ();

    }
}

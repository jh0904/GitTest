package cn.net.TCP;

import java.io.*;
import java.net.Socket;

/**
 * cn.net.TCP
 *
 * @author jh
 * @date 2018/7/5 23:57
 * description: 客户端实现文件读取，在发送到服务器。
 */
public class ClientDemo4 {
    public static void main(String[] args) throws IOException {
        Socket s=new Socket ("10.10.10.01",34567);

        BufferedReader br=new BufferedReader (new FileReader ("GitTest1/aa.txt"));

        BufferedWriter bw=new BufferedWriter (new OutputStreamWriter (s.getOutputStream ()));

        String line = null;
        while ((line = br.readLine ()) != null) {
            bw.write (line);
            bw.newLine ();
            bw.flush ();
        }
        br.close ();
        s.close ();

    }
}

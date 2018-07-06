package cn.net.TCP.Client;

import java.io.*;
import java.net.Socket;

/**
 * cn.net.TCP
 *
 * @author jh
 * @date 2018/7/5 23:57
 * description: 客户端文件传输服务器，自定义结束标记，可以解决问题，但是不好万一文本里面有对应的的字符串。
 */
public class UploadClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket ("10.10.10.01", 11111);

        BufferedReader br = new BufferedReader (new FileReader ("GitTest1/bb.txt"));

        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (s.getOutputStream ()));

        String line = null;
        while ((line = br.readLine ()) != null) {
            bw.write (line);
            bw.newLine ();
            bw.flush ();
        }
        //自定义结束标记，可以解决问题，但是不好万一文本里面有对应的的字符串。
        bw.write ("over");
        bw.newLine ();
        bw.flush ();
        //接收反馈
        BufferedReader brClient = new BufferedReader (new InputStreamReader (s.getInputStream ()));
        String line1 = brClient.readLine ();
        System.out.println (line1);

        br.close ();
        s.close ();

    }
}

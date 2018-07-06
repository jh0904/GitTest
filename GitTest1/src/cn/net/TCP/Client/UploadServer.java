package cn.net.TCP.Client;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * cn.net.TCP
 *
 * @author jh
 * @date 2018/7/5 23:50
 * description:
 */
public class UploadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket (11111);

        Socket s = ss.accept ();

        BufferedReader br = new BufferedReader (new InputStreamReader (s.getInputStream ()));

        BufferedWriter bw = new BufferedWriter (new FileWriter ("GitTest1/Copy.txt"));

        String line = null;
        while ((line = br.readLine ()) != null) {
            if ("over".equals (line)) {
                break;
            }
            bw.write (line);
            bw.newLine ();
            bw.flush ();
        }

        //反馈
        BufferedWriter bwServer = new BufferedWriter (new OutputStreamWriter (s.getOutputStream ()));
        bwServer.write ("文件上传成功！");
        bwServer.newLine ();
        bwServer.flush ();

        bw.close ();
        s.close ();
    }
}


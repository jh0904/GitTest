package cn.net.TCP;

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
public class ServerDemo3 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket (12345);

        Socket s = ss.accept ();

        BufferedReader br = new BufferedReader (new InputStreamReader (s.getInputStream ()));

        BufferedWriter bw = new BufferedWriter (new FileWriter ("jh.txt"));

        String line = null;
        while ((line = br.readLine ()) != null) {
            bw.write (line);
            bw.newLine ();
            bw.flush ();
        }
        bw.close ();
        s.close ();
    }
}


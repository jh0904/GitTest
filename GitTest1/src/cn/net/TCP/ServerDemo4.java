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
public class ServerDemo4 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket (34567);

        Socket s = ss.accept ();

        BufferedReader br = new BufferedReader (new InputStreamReader (s.getInputStream ()));


        String line = null;
        while ((line = br.readLine ()) != null) {
            System.out.println (line);
        }
        s.close ();
    }
}


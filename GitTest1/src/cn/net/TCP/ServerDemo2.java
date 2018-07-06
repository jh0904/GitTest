package cn.net.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * cn.net.TCP
 *
 * @author jh
 * @date 2018/7/5 17:03
 * description:
 */
public class ServerDemo2 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket (11111);
        //阻塞
        Socket s = ss.accept ();

        BufferedReader br=new BufferedReader (new InputStreamReader (s.getInputStream ()));

        String s1 = null;
        while((s1=br.readLine ())!=null){
            System.out.println (s1);
        }

        s.close ();
    }
}

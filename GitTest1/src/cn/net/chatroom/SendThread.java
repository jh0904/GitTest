package cn.net.chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * cn.net
 *
 * @author jh
 * @date 2018/7/5 15:21
 * description:
 */
public class SendThread implements Runnable {
    private DatagramSocket ds;

    public SendThread(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
            String line;
            while ((line = br.readLine ()) != null) {
                if ("886".equals (line)) {
                    break;
                }
                byte[] buf = line.getBytes ();
                DatagramPacket dp = new DatagramPacket (buf, buf.length, InetAddress.getByName ("10.10.10.255"), 10024);
                ds.send (dp);
            }
            ds.close ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}

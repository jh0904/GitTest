package cn.net.UDP;

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
 * @date 2018/7/5 10:31
 * description:
 */
public class UDPSendDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket ();
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        String line ;
        while ((line = br.readLine ()) != null) {
            if("886".equals (line)){
                break;
            }
            byte[] buf = line.getBytes ();
            DatagramPacket dp = new DatagramPacket (buf, buf.length, InetAddress.getByName ("10.10.10.1"), 10087);
            ds.send (dp);
        }
        ds.close ();
    }
}

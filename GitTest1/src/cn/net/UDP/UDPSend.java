package cn.net.UDP;

import java.io.IOException;
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
public class UDPSend {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds=new DatagramSocket ();

        byte[] buf="hellcat".getBytes ();
        DatagramPacket dp=new DatagramPacket (buf,buf.length,InetAddress.getByName ("10.10.10.1"),10086);
        ds.send (dp);
        ds.close ();
    }
}

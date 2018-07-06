package cn.net.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * cn.net
 *
 * @author jh
 * @date 2018/7/5 14:23
 * description:
 */
public class UDPRecive {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds=new DatagramSocket (10086);

        byte[] but=new byte[1024];
        DatagramPacket dp=new DatagramPacket (but,but.length);

        ds.receive (dp);

        String hostAddress = dp.getAddress ().getHostName ();
        String s=new String (dp.getData (),0,dp.getLength ());
        System.out.println (hostAddress+":"+s);
        ds.close ();
    }
}

package cn.net.chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * cn.net
 *
 * @author jh
 * @date 2018/7/5 15:21
 * description:
 */
public class ReciveThread implements Runnable {
    private DatagramSocket ds;

    public ReciveThread(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        try {
            while (true){
                byte[] but=new byte[1024];
                DatagramPacket dp=new DatagramPacket (but,but.length);

                ds.receive (dp);

                String hostAddress = dp.getAddress ().getHostName ();
                String s=new String (dp.getData (),0,dp.getLength ());
                System.out.println (hostAddress+":"+s);
            }
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}

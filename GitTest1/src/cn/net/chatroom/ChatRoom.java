package cn.net.chatroom;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * cn.net
 *
 * @author jh
 * @date 2018/7/5 15:17
 * description: 基于UDP的聊天室程序。
 */
public class ChatRoom {
    public static void main(String[] args) throws SocketException {
        DatagramSocket sendDs = new DatagramSocket ();
        DatagramSocket reciveDs = new DatagramSocket (10024);

        SendThread st = new SendThread (sendDs);
        ReciveThread rt = new ReciveThread (reciveDs);

        Thread t1 = new Thread (st);
        Thread t2 = new Thread (rt);

        t1.start ();
        t2.start ();
    }
}

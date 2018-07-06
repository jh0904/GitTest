package cn.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * cn.net
 *
 * @author jh
 * @date 2018/7/5 9:05
 * description:
 */
public class InetAddressTest {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress jh = InetAddress.getByName ("jh");
        System.out.println (jh.toString ());
    }
}

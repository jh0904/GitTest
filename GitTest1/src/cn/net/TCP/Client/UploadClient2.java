package cn.net.TCP.Client;

import java.io.*;
import java.net.Socket;

/**
 * cn.net.TCP
 *
 * @author jh
 * @date 2018/7/5 23:57
 * description: 客户端文件传输服务器，shutdownOutput停止转换。
 */
public class UploadClient2 {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket ("10.10.10.01", 11111);

        BufferedInputStream bis=new BufferedInputStream (new FileInputStream ("GitTest1/aa.jpg"));
        BufferedOutputStream bos = new BufferedOutputStream (s.getOutputStream ());


        byte[] bys = new byte[1024];
        int len = 0;
        while ((len = bis.read(bys)) != -1) {
            bos.write(bys, 0, len);
            bos.flush();
        }

        s.shutdownOutput();

        // 读取反馈
        InputStream is = s.getInputStream();
        byte[] bys2 = new byte[1024];
        int len2 = is.read(bys2);
        String client = new String(bys2, 0, len2);
        System.out.println(client);

        // 释放资源
        bis.close();
        s.close();

    }
}

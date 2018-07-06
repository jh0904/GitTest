package cn.net.TCP.Client;

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
public class UploadServer2 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket (11111);

        Socket s = ss.accept ();

        BufferedInputStream bis=new BufferedInputStream (s.getInputStream ());
        BufferedOutputStream bos = new BufferedOutputStream (new FileOutputStream ("mm.jpg"));

        byte[] bys=new byte[1024];
        int len=0;
        while ((len=bis.read (bys))!=-1) {
            bos.write (bys,0,len);
        }

        //反馈
        OutputStream os=s.getOutputStream ();
        os.write ("图片上传成功".getBytes ());

        bos.close ();
        s.close ();
    }
}


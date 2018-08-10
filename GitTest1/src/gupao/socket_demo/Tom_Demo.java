package gupao.socket_demo;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * gupao.socket_demo
 *
 * @author jh
 * @date 2018/8/9 21:18
 * description:
 */
public class Tom_Demo {
	public static void main(String[] args) {
		try {
			ServerSocket socket = new ServerSocket (9999);
			while (true) {
				Socket accept = socket.accept ();
				InputStream is = accept.getInputStream ();
				int len=0;
				byte[] buffer=new byte[1024];
				while ((len=is.read (buffer))>0) {
					System.out.println (new String (buffer, 0, len));
				}
			}

		} catch (IOException e) {
			e.printStackTrace ();
		}
	}
}

package gupao.socket_demo;

import javafx.concurrent.Worker;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * gupao.socket_demo
 *
 * @author jh
 * @date 2018/8/8 21:14
 * description:
 */
public class SocketServer {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket=null;
		try {
			serverSocket = new ServerSocket (8888);

			while(true){
				Socket socket = serverSocket.accept ();
				new Thread (()->{
					try {
						BufferedReader reader = new BufferedReader (new InputStreamReader (socket.getInputStream ()));
						PrintWriter writer = new PrintWriter (new OutputStreamWriter (socket.getOutputStream ()));
						while (true){
							String readLine = reader.readLine ();
							if(readLine!=null){
								break;
							}
							System.out.println ("服务端接受的数据"+readLine);

							writer.print ("Mic");
							writer.flush ();
						}
					} catch (IOException e) {
						e.printStackTrace ();
					}
				});

			}
		} catch (IOException e) {
			e.printStackTrace ();
		}finally {
			if(serverSocket!=null){
				serverSocket.close ();
			}
		}
	}
}

package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	public static void main(String args[]) {
		try(
				//tcpサーバー生成
				ServerSocket serverSocket = new ServerSocket();
				)
		{
			InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 9999);
			serverSocket.bind(inetSocketAddress);
			System.out.println("Waiting for any access");
			//接続待ち
			Socket socket = serverSocket.accept();
			System.out.println("Anyone access");
			while(true) {
				//受信テキストの受け取り
				InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				String request = bufferedReader.readLine();
				if(request.equals("exit")) {
					System.out.println("Finish");
					break;
				}
				//受信テキストの出力
				System.out.println(request);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
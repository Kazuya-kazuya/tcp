package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		try (
				//接続先の設定とコンソール入力の準備
				Socket socket = new Socket("127.0.0.1", 9999);
				InputStreamReader inputStreamReader = new InputStreamReader(System.in)
				)
		{
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter printWriter = new PrintWriter(outputStream, true);
			while(true) {
				System.out.println("Please input");
				//コンソール入力
				String str = bufferedReader.readLine();
				//入力テキストの送信
				printWriter.println(str);
				if(str.equals("exit")) {
					break;
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}

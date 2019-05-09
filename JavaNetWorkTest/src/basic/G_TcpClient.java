package basic;

import java.net.Socket;

public class G_TcpClient {

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("192.168.206.34", 7777);
		System.out.println("서버에 연결 되었습니다.");
		
		Sender sender = new Sender(socket);
		Receiver receiver = new Receiver(socket);
		
		sender.start();
		receiver.start();
	}

}

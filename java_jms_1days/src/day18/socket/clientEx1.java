package day18.socket;

import java.net.Socket;


public class clientEx1 {

	public static void main(String[] args) {
		
		int port = 5001;
		String ip = "192.168.30.212";
		try {
			Socket socket = new Socket(ip, port);
			Client client = new Client(socket);
			client.send();
			client.receive();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package day18.socket;

import java.net.InetAddress;
import java.net.Socket;


public class clientEx1 {

	public static void main(String[] args) {
		
		int port = 3000;
		String ip;
		try {
//			InetAddress ip2 = InetAddress.getLocalHost();
//			System.out.println(ip2);
			ip = InetAddress.getLocalHost().getHostAddress();
			System.out.println(ip);
			Socket socket = new Socket(ip, port);
			
			
			Client client = new Client(socket);
			client.send();
			client.receive();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

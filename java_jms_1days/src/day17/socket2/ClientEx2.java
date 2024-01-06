package day17.socket2;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientEx2 {

	public static void main(String[] args) {
		//ip, port 번호 설정 <- 서버의 번호
		String ip = "192.168.30.212";
		int port = 5001;
		
		ArrayList<String> list = null;
	
		//1. ip와 port를 이용해 소켓 생성 및 대기
		//2.연결 요청
		Socket socket;
		try {
			socket = new Socket(ip, port);
			//2-2 연결요청 
			//socket.connect(new InetSocketAddress(ip, port));
			
			//3. 작업
			System.out.println("연결 성공");
			
			//받는 기능
			Thread receiveThread = new Thread(()->{
				try {
					ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
					while (true) {
						//상대방이 채팅을 보내면 서버쪽에 출력하는 예제
						String str = ois.readUTF();
						if(str.equals("-1")) {
							break;
						}
						System.out.println(str);
					}
					
				} catch (IOException e) {
					e.printStackTrace();
					
				}
				System.out.println("클라이언트 : 받는 기능 종료");
			});
			receiveThread.start();
			
			//보내는 기능
			//문자열을 입력받아 클라이언트에 전송하는 쓰레드
			Thread sendThread = new Thread(()->{
				try {
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					Scanner scan = new Scanner(System.in);
					while (true) {
						String str = scan.nextLine();
						oos.writeUTF(str);
						oos.flush();
						if(str.equals("-1")) {
							break;
						}
					}
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				System.out.println("클라이언트 : 보내는 기능 종료");
			});
			sendThread.start();
			
			
		} catch (UnknownHostException e) {
			System.out.println("연결 할 수 없습니다.");
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("예외 발생.");
		}
		System.out.println("클라이언트 : 메인 기능 종료");
	}

}

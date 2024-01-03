package day17.socket1;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientEx1 {

	public static void main(String[] args) {
		//ip, port 번호 설정 <- 서버의 번호
		String ip = "192.168.30.212";
		int port = 5001;
		
		Scanner scan = new Scanner(System.in);
		
		ArrayList<String> list = null;
	
		//1. ip와 port를 이용해 소켓 생성 및 대기
		//2.연결 요청
		try (Socket socket = new Socket(ip, port)){
			
			//2-2 연결요청 
			//socket.connect(new InetSocketAddress(ip, port));
			
			//3. 작업
			System.out.println("연결 성공");
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			// 서버에서 채팅 내역을 가져옴
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			list = (ArrayList<String>) ois.readObject();
			
			//채팅 내역을 조회
			System.out.println(list);
			
			//채팅 여러번 보내기
			while(true) {
				System.out.println("내용 : [종료 : -1]");
				
				String str = scan.nextLine();
				oos.writeUTF(str);
				oos.flush();
				if(str.equals("-1")) {
					break;
				}
				list.add(str);
			}
			
			oos.close();
			
		} catch (UnknownHostException e) {
			System.out.println("연결 할 수 없습니다.");
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("예외 발생.");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

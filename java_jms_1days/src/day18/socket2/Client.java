package day18.socket2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Client {
	private Socket socket;
	//받는 메서드
	public void receive() {
		
		Thread t = new Thread(()->{
			ObjectInputStream ois = null;
			try{
				ois = new ObjectInputStream(socket.getInputStream());
				while (true) {
					String str = ois.readUTF();
					if(str.equals("-1")) {
						break;
					}
					System.out.println(str);
				}
				System.out.println("읽기 기능이 정상 종료 됩니다.");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("예외가 발생해서 읽기 기능을 종료 합니다.");
				
			}
		});
		t.start();
		
		//Thread t = new Thread(()->{});
		//람다식 안했을때 코드 (위 코드랑 똑같은 코드)
//		Thread t = new Thread(new Runnable() {
//				
//			@Override
//			public void run() {
//				
//			}
//		});
	}
	//보내는 메서드
	public void send() {
		Thread t = new Thread(()->{
			ObjectOutputStream oos = null;
			try {
				oos = new ObjectOutputStream(socket.getOutputStream());
				Scanner scan = new Scanner(System.in);
				while(true) {
					String str = scan.nextLine();
					oos.writeUTF(str);
					oos.flush();
					if(str.equals("-1")) {
						break;
					}
				}
				System.out.println("전송 기능이 정상적을 종료 됩니다.");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("예외가 발생해서 전송기능을 종료합니다.");
			}
			
		});
		t.start();
	}
}








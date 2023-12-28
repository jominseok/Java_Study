	package day14;
	
	import lombok.Data;
	
	public class ExceptionEx4 {
	
		//사용자가 만든 예외처리문 사용 방법
		public static void main(String[] args) {
			
			try {
				test();
			} catch (MyException e) {
				e.print();
				e.printStackTrace();
			}
			try {
				System.out.println(1/0);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();// 예외가 발생한 것들을 차례대로 잡아줌
			}
			
			System.out.println("종료");
		}
		
		public static void test() throws MyException{
			throw new MyException("안녕하세요", "무조건 예외 발생");
		}
	
	}
	
	
	//사용자가 만드는 예외처리문 
	@Data
	class MyException extends Exception{
		
		private String title;
		
		public MyException() {}
		
		public MyException(String title, String message) {
			super(message);
			this.title = title;
		}
		
		public void print() {
			System.out.println(title);
			System.out.println(getMessage());
		}
	}

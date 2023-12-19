package day08;

public class Car {
	// ↓↓↓↓추상화 하는 방법
		// 멤버 변수 : 
		
		// 메서드 : 
	/* 정보 : 멤버변수 
	 무게 : 단위는 톤으로, 브랜드, 분류, 색상, 바퀴 종류, 차명, 연식*/	
	
	// 무게 단위는 톤으로
	double weight;
	// 브랜드
	String brand;
	// 분류
	String category;
	//0xff0000
	//int color;
	String color;
	String [] tires;
	String carName;
	int year;
	boolean power;//시동
	int speed;//현재 속력
	boolean leftLight;
	boolean RightLight;
	
	//기능 : 메서드 
	//가속(엑셀을 밟음), 감속(브레이크를 밟음), 
	//		좌측 우측 깜박이 켜기/끄기
	
	//시동을 켜기/끄기
	//시동이 꺼져있으면 켜짐, 시동이 켜져있으면 꺼짐
	public void turn() {
		power = !power;
		if(power) {
			System.out.println("시동이 켜졌습니다.");
		}else {
			System.out.println("시동이 꺼졌습니다.");
		}
	}
	
	//가속
	public void speedUp() {
		speed++;
	}
	//감속
	public void speedDown() {
		speed--;
	}
	//좌측|우측 깜박이 켜기/끄기, 위 : 우측1, 가운데0, 아래 : 좌측-1
	public void turnLight(int direction) {
		switch (direction) {
		case 1: RightLight = true; leftLight = false; break;
		case 0: RightLight = false; leftLight = false; break;
		case -1: RightLight = false; leftLight = true; break;
		default:
			
		}
	}
	
	//자동차 현재 상태를 출력하는 메서드
	public void print() {
		System.out.println("=====================================" );
		System.out.println("시동 : " + power);
		System.out.println("속력 : " + speed);
		System.out.println("좌깜 : " + leftLight);
		System.out.println("우깜 : " + RightLight);
		System.out.println("=====================================" );
	}

	
}

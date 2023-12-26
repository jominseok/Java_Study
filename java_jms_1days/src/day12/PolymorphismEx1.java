package day12;

import java.rmi.Remote;

public class PolymorphismEx1 {

	public static void main(String[] args) {
		/* 다형성 예제
		 * 1. 매개변수의 다형성
		 * */
		
		remocon r = new remocon();
		TV tv = new TV();
		AirConditioner aircon = new AirConditioner();
		Projector projector = new Projector();
		r.turnOn(tv);
		r.turnOn(aircon);
		r.turnOn(projector);
		
	}

}

//리모컨 : TV나 에어컨 등을 켜는 기기
class remocon{
	
	/*
	void trunOn(TV target) {
		System.out.println("TV제품이 켜졌습니다.");
	}
	
	void trunOn(AirConditioner target) {
		System.out.println("에어컨 제품이 켜졌습니다.");
	}
	
	/* 매개변수의 다형성을 이용하여 trunOn메서드를 
	 * 1개만 생성*/
	void turnOn(ElectronicProduct target) {
		if(target instanceof TV) {
			System.out.println("Tv");
		}else if(target instanceof AirConditioner) {
			System.out.println("에어컨");
		}else if(target instanceof Projector) {
			System.out.println("빔 프로젝터");
		}else {
			System.out.println("전자 ");
		}
		System.out.println("제품이 켜졌습니다.");
	}
}

//전자제품
class ElectronicProduct{
	
}

class TV extends ElectronicProduct{
	
}

class AirConditioner extends ElectronicProduct{
	
}

class Projector extends ElectronicProduct{
	
}
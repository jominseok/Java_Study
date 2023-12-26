package day12;

public class InheritanceEx1 {

	public static void main(String[] args) {
		/*상속 예제*/
		Car c1 = new Car("K3", "기아", 4);
		c1.print();
		
		KiaCar k1 = new KiaCar("레이", 4);
		k1.print();
		
		HyundaiCar h1 = new HyundaiCar("아반뗴", 4);
		h1.print();
	}

}


//자동차
class Car{
	String name, brand;
	int wheelcount;
	boolean power;
	int speed;
	
	void turn() {
		power = !power;
	}
	
	void speed(int speed) {
		this.speed += speed;
	}

	public Car(String name, String brand, int wheelcount) {
		super();
		this.name = name;
		this.wheelcount = wheelcount;
		this.brand = brand;
	}
	
	public void print() {
		System.out.println("회사 : " + brand);
		System.out.println("차명 : " + name);
	}
	
}

//기아차 : 기아자동차는 자동차이다
class KiaCar extends Car{
	public KiaCar(String name, int wheelCount) {
		/*brand = "기아";
		this.name = name;
		this.wheelcount = wheelCount;*/
		super(name, "Kia", wheelCount);
	}
	
}


//현대차 : 현대자동차는 자동차이다
class HyundaiCar extends Car{
	public HyundaiCar(String name, int wheelCount) {
		/*
		brand = "현대";
		this.name = name;
		this.wheelcount = wheelCount;
		*/
		super(name, "Hyundai", wheelCount);
	}
}

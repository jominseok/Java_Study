package day10;

public class StaticEx1 {

	public static void main(String[] args) {
		KiaCar c1;
		c1 = new KiaCar("모닝");
		KiaCar c2;
		c2 = new KiaCar("레이");
		KiaCar c3;
		c3 = new KiaCar("k3");
		//KiaCar에서 brand는 Static이 아니기 때문에 인스턴스마다 brand를 수정해야함
		c1.brand = "기아";
		//인스턴스를 통해서 접근이가능하지만 static변수는 클래스명을 통해 접근해야 함
		KiaCar2.brand = "기아";
		c1.print();
		c2.print();
		c3.print();
		
		KiaCar2 c4;
		//인스턴스가 생성되기전에 static변수인 brand는 이미 메모리에 올라가있어서
		//사용할수 있음
		System.out.println(KiaCar2.brand);
		c4 = new KiaCar2("모닝");
		KiaCar2 c5 = new KiaCar2("레이");
		KiaCar2 c6 = new KiaCar2("k3");
		//KiaCar에서 brand는 Static이 아니기 때문에 인스턴스마다 brand를 수정해야함
		c1.brand = "기아";
		c1.print();
		c2.print();
		c3.print();
		
		System.out.println("대표적인 static 변수 Math.PI : " + Math.PI);
	}

}


class KiaCar{
	
	public String brand = "Kia";// 명시적 초기화
	public String name;//차명(레이, 아반떼, 그렌져, gv80등) // 기본 초기화
	
	public KiaCar(String name) {
		this.name = name;
	}

	public void print() {
		System.out.println(brand);
		System.out.println("차명 : " + name);
	}
}

class KiaCar2{
	
	public static String brand = "Kia";
	public String name;//차명(레이, 아반떼, 그렌져, gv80등)
	
	public KiaCar2(String name) {
		this.name = name;
	}
	
	public void print() {
		System.out.println(brand);
		System.out.println("차명 : " + name);
	}
}
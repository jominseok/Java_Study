package day12.product;

public class TV extends product {
	int screenSize;
	
	
	public TV(String brand, String productCode, String name, int screenSize) {
		super(brand, productCode, name);
		this.screenSize = screenSize;
	}


	@Override
	public void print() {
		System.out.println("-----------------");
		System.out.println("브랜드 : " + brand);
		System.out.println("제품명 : " + name);
		System.out.println("코드 : " + productCode);
		System.out.println("화면크기 : " + screenSize + "cm");
		
	}
}

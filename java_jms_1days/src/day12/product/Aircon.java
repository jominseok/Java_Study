package day12.product;

public class Aircon extends product {
	double coolingArea;
	
	
	public Aircon(String brand, String productCode, String name, double coolingArea) {
		super(brand, productCode, name);
		this.coolingArea = coolingArea;
	}


	@Override
	public void print() {
		System.out.println("-----------------");
		System.out.println("브랜드 : " + brand);
		System.out.println("제품명 : " + name);
		System.out.println("코드 : " + productCode);
		System.out.println("냉방면적 : " + coolingArea + "m");
	}
	
	
}

package day12.product;

public class Laptop extends product {
	double CPU; 
	int RAM;
	
	
	public Laptop(String brand, String productCode, String name, double CPU, int RAM) {
		super(brand, productCode, name);
		this.CPU = CPU;
		this.RAM = RAM;
	}


	@Override
	public void print() {
		System.out.println("-----------------");
		System.out.println("브랜드 : " + brand);
		System.out.println("제품명 : " + name);
		System.out.println("코드 : " + productCode);
		System.out.println("CPU : " + CPU + "Ghz");
		System.out.println("RAM : " + RAM + "G");
	}
	
}

package day12.product;

public abstract class product {
	String brand, productCode, name;
	
	public product(String brand, String productCode, String name) {
		super();
		this.brand = brand;
		this.productCode = productCode;
		this.name = name;
	}
	
	public abstract void print();

}

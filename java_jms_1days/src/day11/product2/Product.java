package day11.product2;

public class Product {
	
	private String name;
	private int amount, buyPrice, price, salePrice;
	

	public Product(String name, int amount, int buyPrice, int price) {
		super();
		this.name = name;
		this.amount = amount;
		this.buyPrice = buyPrice;
		this.price = price;
		this.salePrice = price;
	}
	
	public void updateAmount(int amount) {
		//기존 수량에 새 수량을 누적
		this.amount += amount;//t
	}

	public boolean equals(String name) {
		return this.name.equals(name);
	}

	public void print() {
		System.out.println("제품 : " + name + ", 수량 : " 
				+ amount + ", 구매가격 : " + buyPrice + ", 판매가격 : " 
				+ price);
	}

	
	public void updateSalePrice(int salePrice2) {
		this.salePrice+=salePrice2;
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(int buyPrice) {
		this.buyPrice = buyPrice;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	


}

package day11.product;


/*
 * 중복된 제품명 X
 * */
public class Product {
	//제품명, 수량, 금액 - 구매금액, 기본판매금액, 할인금액
	String Products;
	String date;
	//getter, setter, 제품 정보 출력, 제품 할인 금액 수정
	//생성자 : 제품명, 수량, 금액이 주어진 생성자
	int price;
	private int amount;
	private int buyPrice;
	private int salePrice;
	
	public Product(int price, String products, String date) {
		super();
		this.price = price;
		this.Products = products;
		this.date = date;
	}

	/** 제품의 가격을 수정하기 위한 메서드
	 * @param price 수정할 제품의 가격을 입력해주세요
	 */
	public void update(int price) {
		this.price = price;
	}
	
	/**
	 * 제품 명으로 서치하는 메서드
	 * @param 제품 명을 넣어주세요
	 * @return
	 */
	public boolean equalsProduct(String Products) {
		return this.Products.equals(Products) ;
	}
	
	/**
	 * 날짜를 비교하는 메서드
	 * @param 날짜를 넣어주세요
	 * @return
	 */
	public boolean equalsDate(String date) {
		return this.date.equals(date) ;
	}

	/**제품의 가격을 프린트 하는 메서드
	 */
	public void printProduct() {
		System.out.println("제품 : " + Products + ", 가격 : " + price + ", 판매 날짜 : " + date);
	}

	


	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}


	public String getProducts() {
		return Products;
	}


	public void setProducts(String products) {
		Products = products;
	}
	
	
	
	
}

package com.tectoro.spring.hibernate.sample.domain;

public class ProductsDomain {
	
	private int productId;
	private String productName;
	private int price;
	
	private VendorDomain domain;
	
	public VendorDomain getDomain() {
		return domain;
	}

	public void setDomain(VendorDomain domain) {
		this.domain = domain;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	

}

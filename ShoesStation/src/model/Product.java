package model;

public class Product {
	
	private int productId;
	private int productStock;
	private int productName;
	private String productTypeId;
	private int productPrice;
	
	public Product(int productId, int productStock, int productName, String productTypeId, int productPrice) {
		super();
		this.productId = productId;
		this.productStock = productStock;
		this.productName = productName;
		this.productTypeId = productTypeId;
		this.productPrice = productPrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

	public int getProductName() {
		return productName;
	}

	public void setProductName(int productName) {
		this.productName = productName;
	}

	public String getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(String productTypeId) {
		this.productTypeId = productTypeId;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

}

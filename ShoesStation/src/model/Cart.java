package model;

public class Cart {
	
	private int productId;
	private String userId;
	private String productName;
	private String productType;
	private int quantity;
	private int productPrice;
	
	public Cart(int productId, String userId, String productName, String productType, int quantity,
			int productPrice) {
		super();
		this.productId = productId;
		this.userId = userId;
		this.productName = productName;
		this.productType = productType;
		this.quantity = quantity;
		this.productPrice = productPrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

}

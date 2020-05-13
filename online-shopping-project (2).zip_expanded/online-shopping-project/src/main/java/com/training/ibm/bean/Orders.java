package com.training.ibm.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	private int userId;
	private int productId;
	private String productName;
	private String productDescription;
	private String productCategory;
	private String productSubCategory;
	private double productPrice;
	private int productQuantity;
	private double subTotal;
	private String productImage;
	
	Orders(){ }

	public Orders(int orderId, int userId, int productId, String productName, String productDescription,
			String productCategory, String productSubCategory, double productPrice, int productQuantity,
			double subTotal, String productImage) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productCategory = productCategory;
		this.productSubCategory = productSubCategory;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.subTotal = subTotal;
		this.productImage = productImage;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductSubCategory() {
		return productSubCategory;
	}

	public void setProductSubCategory(String productSubCategory) {
		this.productSubCategory = productSubCategory;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	
}

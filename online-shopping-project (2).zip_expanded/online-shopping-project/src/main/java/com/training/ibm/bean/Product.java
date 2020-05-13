package com.training.ibm.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer productId;

	private String productCategory;
	private String productSubCategory;
	private String productDescription;
	private String productName;
	private double productPrice;
	private Integer unitStock;
	private String productImage;

	public Product() {
	}

	public Product(Integer productId, String productCategory, String productSubCategory, String productDescription,
			String productName, double productPrice, Integer unitStock, String productImage) {
		this.productId = productId;
		this.productCategory = productCategory;
		this.productSubCategory = productSubCategory;
		this.productDescription = productDescription;
		this.productName = productName;
		this.productPrice = productPrice;
		this.unitStock = unitStock;
		this.productImage = productImage;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
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

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getUnitStock() {
		return unitStock;
	}

	public void setUnitStock(Integer unitStock) {
		this.unitStock = unitStock;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	

}

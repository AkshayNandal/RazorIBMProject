package com.ibm.main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 Integer productId;
	 String productCategory;
	 String productSubCategory;
	 String productDescription;
	 String productName;
	 double productPrice;
	 String unitStock;
	 String productImage;
	 
	 public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductSubCategory() {
			return productSubCategory;
		}
	public void setProductSubCategory(String productSubCategory) {
			this.productSubCategory = productSubCategory;
	}
	 Integer getProductId() {
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
	public String getUnitStock() {
		return unitStock;
	}
	public void setUnitStock(String unitStock) {
		this.unitStock = unitStock;
	}
	
}

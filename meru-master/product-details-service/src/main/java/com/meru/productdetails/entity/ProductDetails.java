package com.meru.productdetails.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ProductDetails implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productId;
	@Column
	private String productName;
	@Column
	private String category;
	@Embedded
	private ProductDescription productDescription;
	@Column
	private String productStatus;
	
	public ProductDetails() {
	}
	

	public ProductDetails(int productId, String productName,  String category,ProductDescription productDescription, String productStatus) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productStatus = productStatus;
		this.category=category;
	}
	
	public ProductDetails(String productName, String category,ProductDescription productDescription, String productStatus) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.productStatus = productStatus;
		this.category=category;
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


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public ProductDescription getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(ProductDescription productDescription) {
		this.productDescription = productDescription;
	}


	public String getProductStatus() {
		return productStatus;
	}


	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return productId+" "+productName+" "+category+" "+productDescription+" "+productStatus ;
	}

	
}

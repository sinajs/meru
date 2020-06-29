package com.meru.productdetails.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ProductDescription implements Serializable{
	
	private double weight;
	private String details;
	private String specification;
	
	public ProductDescription()
	{
		
	}

	public ProductDescription(double weight, String details, String specification) {
		super();
		this.weight = weight;
		this.details = details;
		this.specification = specification;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return details+" "+specification+" "+weight;
	}
}

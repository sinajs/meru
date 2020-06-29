package com.meru.product.view.app.entiry;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Price implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column
	private int priceId;
	@Column(name = "priceProductId",insertable = false, updatable = false)
	private int productId;
	@Column
	private double price;

	public Price() {
	}

	public Price(int priceId, int productId, double price) {
		super();
		this.priceId = priceId;
		this.productId = productId;
		this.price = price;
	}

	public int getPriceId() {
		return priceId;
	}

	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Price [priceId=" + priceId + ", productId=" + productId + ", price=" + price + "]";
	}
}

package com.meru.price.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Price")
public class Price {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int priceId;
    private int productId;
    private double price;

    public Price() {

    }

    public Price(int priceId, int productId, double price) {
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
}

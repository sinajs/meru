package com.meru.inventory.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inventory implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int inventoryId;
	@Column
	private int productId;
	@Column
	private int qty;
	@Column
	private String pickZone;
	@Column
	private String packZone;
	@Column
	private String ShippingArea;

	public Inventory() {
	}

	public Inventory(int inventoryId, int productId, int qty, String pickZone, String packZone, String shippingArea) {
		super();
		this.inventoryId = inventoryId;
		this.productId = productId;
		this.qty = qty;
		this.pickZone = pickZone;
		this.packZone = packZone;
		ShippingArea = shippingArea;
	}
	public Inventory(int productId, int qty, String pickZone, String packZone, String shippingArea) {
		super();
		this.productId = productId;
		this.qty = qty;
		this.pickZone = pickZone;
		this.packZone = packZone;
		ShippingArea = shippingArea;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getPickZone() {
		return pickZone;
	}

	public void setPickZone(String pickZone) {
		this.pickZone = pickZone;
	}

	public String getPackZone() {
		return packZone;
	}

	public void setPackZone(String packZone) {
		this.packZone = packZone;
	}

	public String getShippingArea() {
		return ShippingArea;
	}

	public void setShippingArea(String shippingArea) {
		ShippingArea = shippingArea;
	}

	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", productId=" + productId + ", qty=" + qty + ", pickZone="
				+ pickZone + ", packZone=" + packZone + ", ShippingArea=" + ShippingArea + "]";
	}
}



package com.meru.product.view.app.entiry;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Inventory implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column
	private int inventoryId;
	@Column(insertable = false, updatable = false)
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

package com.meru.product.view.app.entiry;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Promotion implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column
	private int promoId;
	@Column(name = "promoProductId",insertable = false, updatable = false)
	private int productId;
	@Column
	private String promoCode;
	@Column
	private String promoDescription;
	@Column
	private Date promoStartDate;
	@Column
	private Date promoEndDate;
	@Column
	private int promoValue;

	public Promotion() {
	}

	public Promotion(int promoId, int productId, String promoCode, String promoDescription, Date promoStartDate,
			Date promoEndDate, int promoValue) {
		super();
		this.promoId = promoId;
		this.productId = productId;
		this.promoCode = promoCode;
		this.promoDescription = promoDescription;
		this.promoStartDate = promoStartDate;
		this.promoEndDate = promoEndDate;
		this.promoValue = promoValue;
	}

	public int getPromoId() {
		return promoId;
	}

	public void setPromoId(int promoId) {
		this.promoId = promoId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public String getPromoDescription() {
		return promoDescription;
	}

	public void setPromoDescription(String promoDescription) {
		this.promoDescription = promoDescription;
	}

	public Date getPromoStartDate() {
		return promoStartDate;
	}

	public void setPromoStartDate(Date promoStartDate) {
		this.promoStartDate = promoStartDate;
	}

	public Date getPromoEndDate() {
		return promoEndDate;
	}

	public void setPromoEndDate(Date promoEndDate) {
		this.promoEndDate = promoEndDate;
	}

	public int getPromoValue() {
		return promoValue;
	}

	public void setPromoValue(int promoValue) {
		this.promoValue = promoValue;
	}

	@Override
	public String toString() {
		return "Promotion [promoId=" + promoId + ", productId=" + productId + ", promoCode=" + promoCode
				+ ", promoDescription=" + promoDescription + ", promoStartDate=" + promoStartDate + ", promoEndDate="
				+ promoEndDate + ", promoValue=" + promoValue + "]";
	}
}

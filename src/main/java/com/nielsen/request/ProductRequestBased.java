package com.nielsen.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class ProductRequestBased implements Serializable {

	private static final long serialVersionUID = 1L;
	@NotNull
	private String productId;
	private String category;
	private String brand;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	private Double relevancyScore;
	 
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Double getRelevancyScore() {
		return relevancyScore;
	}
	public void setRelevancyScore(Double relevancyScore) {
		this.relevancyScore = relevancyScore;
	}
}

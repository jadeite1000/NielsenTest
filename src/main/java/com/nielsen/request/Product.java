package com.nielsen.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@NotNull
	private String productId;
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

package com.nielsen.request;



import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;



public class ProductRequest implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotNull
    private String productId;

    @Min(value = 10, message = "Limit must be at least 10")
    @Max(value = 1000, message = "Limit cannot exceed 1000")
    private Integer limit = 10;
    
    private Double relevancyScore;
    
	public Double getRelevancyScore() {
		return relevancyScore;
	}

	public void setRelevancyScore(Double relevancyScore) {
		this.relevancyScore = relevancyScore;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

}

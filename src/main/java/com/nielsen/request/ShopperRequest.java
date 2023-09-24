package com.nielsen.request;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.nielsen.model.ProductEntity;

public class ShopperRequest extends ShopperRequestBased implements Serializable{

	private static final long serialVersionUID = 1L;

	

    private String category;

    private String brand;

    @Min(value = 10)
    @Max(value = 100)
    private Integer limit = 10;

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

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}


}

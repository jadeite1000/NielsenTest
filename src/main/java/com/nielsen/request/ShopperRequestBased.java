package com.nielsen.request;

import java.util.List;

import javax.validation.constraints.NotNull;

public class ShopperRequestBased {
	@NotNull
    private String shopperId;
	private List<ProductRequestBased> shelf;
	
	public List<ProductRequestBased> getShelf() {
		return shelf;
	}

	public void setShelf(List<ProductRequestBased> shelf) {
		this.shelf = shelf;
	}

	public String getShopperId() {
		return shopperId;
	}

	public void setShopperId(String shopperId) {
		this.shopperId = shopperId;
	}
	

}

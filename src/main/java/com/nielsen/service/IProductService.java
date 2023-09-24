package com.nielsen.service;

import java.util.List;

import com.nielsen.model.ProductEntity;

public interface IProductService {
	// This method returns an arraylist of products based on the shopper id, category, brand and limit
		public List<ProductEntity> findByShopperIdAndCategoryAndBrand(String shopperId, String category, String brand, Integer limit);

}

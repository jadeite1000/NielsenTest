package com.nielsen.service;

import java.util.ArrayList;
import java.util.List;
import com.nielsen.model.ProductEntity;
import com.nielsen.request.ProductRequestBased;


public interface IProductService {
	// This method returns an arraylist of products based on the shopper id, category, brand and limit
		public List<ProductEntity> getProductsByShopper(String shopperId, String category, String brand, Integer limit);
		public List<ProductEntity> save(ArrayList<ProductRequestBased> products) throws Exception;
}

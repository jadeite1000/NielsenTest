package com.nielsen.service;

import java.util.ArrayList;
import java.util.List;

import com.nielsen.model.ShopperEntity;
import com.nielsen.request.ShopperRequest;
import com.nielsen.request.ShopperRequestBased;

public interface IShopperService {
	    // This method returns a shopper object based on the product id and limit
		public ShopperEntity findByProductIdAndLimit(String productId, Integer limit);
		public List<ShopperEntity> save(ArrayList<ShopperRequestBased> shoppers) throws Exception;
}

package com.nielsen.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nielsen.model.ProductEntity;
import com.nielsen.model.ShopperEntity;
import com.nielsen.repository.ShopperRepository;
import com.nielsen.request.ProductRequestBased;
import com.nielsen.request.ShopperRequest;
import com.nielsen.request.ShopperRequestBased;
import com.nielsen.service.IProductService;
import com.nielsen.service.IShopperService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ShopperServiceImpl implements IShopperService{

	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private ShopperRepository shopperRepository;
	
	// This method returns a shopper object based on the product id and limit
	public ShopperEntity findByProductIdAndLimit(String productId, Integer limit) {
	    // Use a query to join the product and shopper tables and filter by the product id
	    String query = "SELECT s FROM ShopperEntity s JOIN s.shelf p WHERE p.productId = :productId";
	    // Create a query object and set the parameter
	    TypedQuery<ShopperEntity> typedQuery = entityManager.createQuery(query, ShopperEntity.class);
	    typedQuery.setParameter("productId", productId);
        //Assuming limit is not a database field.
	    if (limit != null) {
	    	typedQuery.setMaxResults(limit);
        }
	
	    // Return the single result or null if none
	    return typedQuery.getSingleResult();
	}
	
	public List<ShopperEntity> save(ArrayList<ShopperRequestBased> shoppers) throws Exception {
		
		ArrayList<ShopperEntity> shopperEntities = new ArrayList<>();
		for (ShopperRequestBased shopper: shoppers) {
			ShopperEntity shopperEntity = new ShopperEntity();
			shopperEntity.setId(shopper.getShopperId());
			ArrayList<ProductEntity> productEntities = new ArrayList<>();
			
			for(ProductRequestBased product: shopper.getShelf()) {
				ProductEntity productEntity = new ProductEntity();
				productEntity.setProductId(product.getProductId());
				productEntity.setRelevancyScore(product.getRelevancyScore());
				productEntity.setCategory(product.getCategory());
				productEntity.setBrand(product.getBrand());
				productEntities.add(productEntity);
			}
			shopperEntity.setShelf(productEntities);
			shopperEntities.add(shopperEntity);
		}

		List<ShopperEntity> saveEntities = shopperRepository.saveAll(shopperEntities);
		
		return saveEntities;
	}

}

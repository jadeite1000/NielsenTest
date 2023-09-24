package com.nielsen.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nielsen.model.ProductEntity;
import com.nielsen.service.IProductService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements IProductService {

	@Autowired
	private EntityManager entityManager;
	
	
	// This method returns an arraylist of products based on the shopper id, category, brand and limit
	public List<ProductEntity> findByShopperIdAndCategoryAndBrand(String shopperId, String category, String brand, Integer limit) {
	    // Use a query to join the product and shopper tables and filter by the criteria
	    String query = "SELECT p FROM ProductEntity p JOIN p.shopper s WHERE s.id = :shopperId AND "
	    		+ "p.category = :category AND p.brand = :brand";
	    // Create a query object and set the parameters
	    TypedQuery<ProductEntity> typedQuery = entityManager.createQuery(query, ProductEntity.class);
	    typedQuery.setParameter("shopperId", shopperId);
	    typedQuery.setParameter("category", category);
	    typedQuery.setParameter("brand", brand);
	    //Assuming limit is not a database field.
	    if (limit != null) {
	    	typedQuery.setMaxResults(limit);
        }
	

	    return typedQuery.getResultList();
	}

}

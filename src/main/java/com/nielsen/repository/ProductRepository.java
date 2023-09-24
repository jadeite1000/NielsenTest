package com.nielsen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nielsen.model.ProductEntity;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    // This method will return a list of products that match the shopper's criteria
    List<ProductEntity> findByCategoryAndBrandAndRelevancyScoreGreaterThanEqual(String category, String brand, Double relevancyScore);

    // This method will return a list of products that match the shopper's id
 //    List<ProductEntity> findByShopperId(String id);
//    
}

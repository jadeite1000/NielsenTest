package com.nielsen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nielsen.model.ShopperEntity;



@Repository
public interface ShopperRepository  extends JpaRepository<ShopperEntity,Long>{


    // This method will save a shopper object to the database
    ShopperEntity save(ShopperEntity shopper);
    
}

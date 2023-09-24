package com.nielsen.controller;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nielsen.model.ProductEntity;
import com.nielsen.model.ShopperEntity;
import com.nielsen.request.ProductRequest;
import com.nielsen.request.ProductRequestBased;
import com.nielsen.request.ShopperRequest;
import com.nielsen.request.ShopperRequestBased;
import com.nielsen.service.IProductService;
import com.nielsen.service.IShopperService;

import java.math.BigDecimal;
import java.util.*;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/")
public class NielsenIQController {

	@Autowired
	private IProductService productService;
	
	@Autowired
	private IShopperService shopperService;
	
	
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/getProductsByShopper", produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<List<ProductEntity>> getProductsByShopper(@Valid @RequestBody ShopperRequest shopper) {

	
		List<ProductEntity> productEntities = productService.getProductsByShopper(shopper.getShopperId(), shopper.getCategory(), shopper.getBrand(), shopper.getLimit());
		
		return new ResponseEntity<List<ProductEntity>>(productEntities,HttpStatus.OK);
	}
	
	@GetMapping("/getShoppersByProduct")
	public ResponseEntity<ShopperEntity> getShopperByProduct(@Valid@ RequestBody ProductRequest product) {
	    

	    
	    ShopperEntity shopperEntity = shopperService.getShopperByProduct(product.getProductId(), product.getLimit());
	    return new ResponseEntity<ShopperEntity>(shopperEntity,HttpStatus.OK);
	    
	} 

	
   @PostMapping("/saveShopperInformation")
   public ResponseEntity<List<ShopperEntity>> saveShopperInformation(@Valid @RequestBody ArrayList<ShopperRequestBased> shoppers) throws Exception {
	     
	
	   List<ShopperEntity> savedShoppers = shopperService.save(shoppers);
	   return new ResponseEntity<List<ShopperEntity>>(savedShoppers,HttpStatus.OK); 
  
   }

   @PostMapping("/saveProductInformation")
   public ResponseEntity<List<ProductEntity>> saveProductsInformation(@Valid @RequestBody ArrayList<ProductRequestBased> products) throws Exception {
	     
	   List<ProductEntity> savedProducts = productService.save(products);
	   return new ResponseEntity<List<ProductEntity>>(savedProducts,HttpStatus.OK); 
  
   }
}

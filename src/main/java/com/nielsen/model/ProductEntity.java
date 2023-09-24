package com.nielsen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;



@Entity
@Table(name = "product")
public class ProductEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	public ProductEntity(Long id, String category, String brand, Double relevancyScore) {
		super();
		this.id = id;
		this.category = category;
		this.brand = brand;
		this.relevancyScore = relevancyScore;
	}

    public ProductEntity() {
  		super();
  		
  	}

    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    



	@Column(name = "productid")
    private String productId;
    
    @Column(nullable = true)
    private String category;



    @Column(nullable = true)
    private String brand;
    
    @Column(nullable = true)
    private Double relevancyScore;



	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Double getRelevancyScore() {
		return relevancyScore;
	}

	public void setRelevancyScore(Double relevancyScore) {
		this.relevancyScore = relevancyScore;
	}


}
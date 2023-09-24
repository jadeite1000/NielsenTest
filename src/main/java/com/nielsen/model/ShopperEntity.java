package com.nielsen.model;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "shopper")
public class ShopperEntity implements Serializable{


	   private static final long serialVersionUID = 1L;

		@Id
		@Column(name = "id")
	    private String id;

	    @OneToMany(cascade = CascadeType.ALL)
	    @JoinTable(name = "shopper_product",
	    joinColumns = @JoinColumn(name = "shopper_id"),
	    inverseJoinColumns = @JoinColumn(name = "id"))
        private List<ProductEntity> shelf;

	    public ShopperEntity(String id, List<ProductEntity> shelf) {
	        this.id = id;
	        this.shelf = shelf;
	    }

	    public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public List<ProductEntity> getShelf() {
			return shelf;
		}

		public void setShelf(List<ProductEntity> shelf) {
			this.shelf = shelf;
		}

		public ShopperEntity() {
	 
	    }
}

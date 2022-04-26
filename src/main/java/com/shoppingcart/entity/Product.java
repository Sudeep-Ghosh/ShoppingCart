package com.shoppingcart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
@Table(name="Product")
public class Product {
		
		@Id 
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="product_id")
		private Long productId;
		
		@Column(nullable = false)
		private String productName;
		
		@Column(nullable = false) 
		private double productPrice;
	
}

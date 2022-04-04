package com.shoppingcart.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
@Table(name="Cart")
public class Cart {
		
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long cartId;
	
	@ManyToOne  
	@JoinColumn(name="user_id" )
	private User user;
	
	@ManyToOne 
	@JoinColumn(name="product_id")
	private Product product;
	
	private int quantity;
	
	
}

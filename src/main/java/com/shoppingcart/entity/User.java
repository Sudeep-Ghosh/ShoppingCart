package com.shoppingcart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
@Table(name="user_t")
public class User {
			
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="user_id")
		private long userId;
		
		private String userName;
		
		private String userPassword;
		
		
		
		
		
		
		
		
		/*
		 * @ManyToMany(cascade = CascadeType.ALL)
		 * 
		 * @JoinTable( name = "user_product", joinColumns = @JoinColumn(name =
		 * "user_id"), inverseJoinColumns = @JoinColumn(name = "product_id") ) private
		 * Collection<Product> product;
		 */
		
		
	
		 
		
}

package com.shoppingcart.service;

import java.util.List;
import java.util.Optional;

import com.shoppingcart.entity.Product;

public interface ProductService {

	public Product addProduct(Product product);
	
	public List<Product> fetchProducts();
	
	public Optional<Product> findById(Long id);

	public void removeProduct(Long productId);
}

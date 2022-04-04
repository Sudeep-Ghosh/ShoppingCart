package com.shoppingcart.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.entity.Product;
import com.shoppingcart.exception.ProductNotExistsException;
import com.shoppingcart.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private  ProductRepository repository;
	
	//addProduct(Product): for adding Product in Product Table
	
	@Override
	public Product addProduct(Product product) {
		
		return repository.save(product);
	}
	
	//fetchProducts(): for displaying list of Products
	@Override
	public List<Product> fetchProducts(){
		return repository.findAll();
	}

	//findById(long): for fetching particular Product from Product Table By Product Id
	@Override
	public Optional<Product> findById(Long id){
		return repository.findById(id);
	}
	
	//removeProduct(long): remove Product from Product Table By Product Id
	@Override
	public void removeProduct(Long productId) {
		repository.deleteById(productId);
	}
}

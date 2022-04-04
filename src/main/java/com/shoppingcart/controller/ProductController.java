package com.shoppingcart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.entity.Product;
import com.shoppingcart.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {

		return service.addProduct(product);
	}

	@DeleteMapping("/deleteProduct/{productId}")
	public void deleteProduct(@PathVariable Long productId) {

		service.removeProduct(productId);
	}

	@GetMapping("/products")
	public List<Product> fetchProducts() {
		return service.fetchProducts();
	}

	@GetMapping("{productId}")
	public Optional<Product> findProduct(@PathVariable("productId") Long productId) {
		return service.findById(productId);
	}

}

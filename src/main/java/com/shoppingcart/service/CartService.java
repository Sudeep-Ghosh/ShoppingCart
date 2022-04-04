package com.shoppingcart.service;

import java.util.List;

import com.shoppingcart.entity.Product;

public interface CartService {

	public void addProductInCart(Long userId, Long productId, int quantity);

	public void removeProductFromCart(Long userId, Long productId);

	public List<Product> getProductsInCart(Long userId);

}

package com.shoppingcart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.entity.Product;
import com.shoppingcart.service.CartService;

@RestController
@RequestMapping("/shoppingCart")
public class CartController {

	private final CartService cartService;

	@Autowired
	public CartController(CartService shoppingCartService) {
		this.cartService = shoppingCartService;

	}

	@PostMapping("/{userId}/addProduct/{productId}")
	public void addProductToCart(@PathVariable("userId") Long userId, @PathVariable("productId") Long productId) {

		cartService.addProductInCart(userId, productId, 1);
	}

	@GetMapping("/{userId}")
	public List<Product> showCart(@PathVariable("userId") Long userId) {
		return cartService.getProductsInCart(userId);
	}

	@DeleteMapping("/removeProduct/{userId}/{productId}")
	public void removeProduct(@PathVariable("userId") Long userId, @PathVariable("productId") Long productId) {
		cartService.removeProductFromCart(userId, productId);
	}
}

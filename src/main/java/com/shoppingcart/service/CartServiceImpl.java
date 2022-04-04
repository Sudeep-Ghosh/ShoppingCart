package com.shoppingcart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.entity.Cart;
import com.shoppingcart.entity.Product;
import com.shoppingcart.entity.User;
import com.shoppingcart.exception.CartIsEmptyException;
import com.shoppingcart.exception.ProductNotInStockException;
import com.shoppingcart.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;

	@Autowired
	private CartRepository cartRepository;

	// addProductInCart(long,long,int): for adding product in user's cart
	@Override
	public void addProductInCart(Long userId, Long productId, int quantity) {

		if (productService.findById(productId).isPresent()) {

			Product product = productService.findById(productId).get();

			User user = userService.getUser(userId).get();

			int qty = 1;

			Cart cartItem = new Cart();

			cartItem.setProduct(product);
			cartItem.setUser(user);
			cartItem.setQuantity(qty);

			cartRepository.save(cartItem);

		} else {
			throw new ProductNotInStockException("Product Not in Stock");
		}
	}

	// getProductsInCart(long): for getting Products Present in User's Cart
	@Override
	public List<Product> getProductsInCart(Long userId) {

		List<Cart> cartList = cartRepository.findAll();

		List<Product> productList = new ArrayList<Product>();

		for (Cart c : cartList) {
			if (c.getUser().getUserId() == userId) {
				Product p = c.getProduct();
				productList.add(p);
			}
		}

		if (productList.isEmpty())
			throw new CartIsEmptyException("No Products In cart");

		return productList;

	}

	// removeProductFromCart(long,long): for Removing Product From User's Cart
	@Override
	public void removeProductFromCart(Long userId, Long productId) {

		List<Cart> cartList = cartRepository.findAll();

		for (Cart c : cartList) {
			if (c.getUser().getUserId() == userId && c.getProduct().getProductId() == productId) {
				Long cartId = c.getCartId();
				cartRepository.deleteById(cartId);

			}
		}

	}

}

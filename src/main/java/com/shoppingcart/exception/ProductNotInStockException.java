package com.shoppingcart.exception;

public class ProductNotInStockException extends RuntimeException {

	public ProductNotInStockException(String mesage){
		super(mesage);
	}
}

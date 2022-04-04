package com.shoppingcart;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shoppingcart.entity.Cart;
import com.shoppingcart.entity.Product;
import com.shoppingcart.entity.User;
import com.shoppingcart.repository.CartRepository;

@SpringBootTest
class AShoppingCartApplicationTests {
	
	@Autowired
	EntityManager em;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testAddOneCartItem() {
		
		Product p=em.find(Product.class, 5L);
		
		User u=em.find(User.class, 2L);
		
		Cart cartItem=new Cart();
		
		cartItem.setUser(u);
		cartItem.setProduct(p);
		cartItem.setQuantity(1);
		
		Cart savedItem=cartRepository.save(cartItem);
		
		Long actualResult = savedItem.getCartId();
		
        assertThat(actualResult).isEqualTo(7L);

	}

}

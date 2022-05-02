package com.shoppingcart.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	@GetMapping("/login")
	public String login(Principal principal) {
		if(principal !=null) {
			return "redirect:/product/products";
		}
		return "/login";
	}
}

package com.shopping.shoppingCart.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
	@RequestMapping(value = "/")
	public String rootInformation() {
		return "Here is the root";
		
	}
	
}

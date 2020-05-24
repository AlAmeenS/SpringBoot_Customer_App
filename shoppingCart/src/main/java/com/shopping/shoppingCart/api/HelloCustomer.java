package com.shopping.shoppingCart.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.shoppingCart.model.Customer;
import com.shopping.shoppingCart.services.CustomerService;

@RestController
@RequestMapping(value = "/customer")
public class HelloCustomer {
	
	@Autowired
	private CustomerService custService;
	
	@RequestMapping(value = "/hello")
	public String sayHello() {
		System.out.println("called hello");
		return "Hello Customer";
	}
	
	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		System.out.println("ddddddd");
		return custService.addCustomer(customer);
	}
	
	@GetMapping("/getCustomer/{custId}")
	public Customer getCustomer(@PathVariable("custId") int id) {
		return custService.getCustomer(id);
	}
	
	@GetMapping("/getCustomers")
	public List<Customer> getCustomers() {
		return custService.getCustomers();
	}
	
	@PutMapping("/updateCustomer/{custId}")
	public Customer updateCustomer(@PathVariable("custId") int id, @RequestBody Customer customer) {
		return custService.updateCustomer(id, customer);
	}
	
	@DeleteMapping("/deleteCustomer/{custId}")
	public boolean deleteCustomer(@PathVariable("custId") int id) {
		return custService.remove(id);
	}
}

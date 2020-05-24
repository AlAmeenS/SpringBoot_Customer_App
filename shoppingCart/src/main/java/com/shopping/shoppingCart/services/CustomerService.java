package com.shopping.shoppingCart.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.shoppingCart.dao.customerDao;
import com.shopping.shoppingCart.exception.CustomerNotFound;
import com.shopping.shoppingCart.model.Customer;

@Service
public class CustomerService {
	@Autowired
	customerDao customerdao;
	/*private int customerIdCount = 0;
	private List<Customer> customerList = new CopyOnWriteArrayList<>();*/
	
	public Customer addCustomer(Customer customer) {
		/*customer.setCustId(customerIdCount);
		customerList.add(customer);
		customerIdCount++;
		return customer;*/
		
		return customerdao.save(customer);
		
	}
	
	public List<Customer> getCustomers() {
		return (List<Customer>) customerdao.findAll();
	}
	
	public Customer getCustomer(int customerId) {
		Optional<Customer> optionalCustomer = customerdao.findById(customerId);
		if(!optionalCustomer.isPresent()) {
			throw new CustomerNotFound("The customer with Id is not found..");
		}
		return optionalCustomer.get();
	}
	
	public Customer updateCustomer(int customerId, Customer customer) {
		customer.setCustId(customerId);
		    /*customerList
				.stream()
				.forEach(c -> {
					if(c.getCustId() == customerId) {
						c.setCustFstNm(customer.getCustFstNm());
						c.setCustLstNm(customer.getCustLstNm());
					}
				});
		    return customerList
		    		.stream()
		    		.filter(c-> c.getCustId() == customerId)
		    		.findFirst()
		    		.get();*/
		return customerdao.save(customer);
		
	}
	
	public boolean remove(int customerId) {
		/*return !customerList.contains(customerList.remove(customerId));*/
		customerdao.deleteById(customerId);
		return !customerdao.existsById(customerId);
	}
}

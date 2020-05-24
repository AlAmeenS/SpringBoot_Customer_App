package com.shopping.shoppingCart.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shopping.shoppingCart.model.Customer;

@Repository
public interface customerDao extends CrudRepository<Customer, Integer>{

}

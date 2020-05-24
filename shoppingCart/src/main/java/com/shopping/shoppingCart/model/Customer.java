package com.shopping.shoppingCart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity()
public class Customer {
	
	@JsonProperty("id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int custId;
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustFstNm() {
		return custFstNm;
	}
	public void setCustFstNm(String custFstNm) {
		this.custFstNm = custFstNm;
	}
	public String getCustLstNm() {
		return custLstNm;
	}
	public void setCustLstNm(String custLstNm) {
		this.custLstNm = custLstNm;
	}
	@JsonProperty("fname")
	private String custFstNm;
	@JsonProperty("lname")
	private String custLstNm;
	
	

}

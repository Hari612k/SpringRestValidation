package com.hari.springprojects.service;

import java.util.List;

import com.hari.springprojects.dto.CustomerDTO;
import com.hari.springprojects.entity.Customer;
import com.hari.springprojects.exception.CustomerNotFoundException;

public interface CustomerService {
	
	public Customer saveCustomer(CustomerDTO customerDTO);
	public List<Customer> getAllCustomers();
	public Customer getCustomer(Integer customerId) throws CustomerNotFoundException;
	

}

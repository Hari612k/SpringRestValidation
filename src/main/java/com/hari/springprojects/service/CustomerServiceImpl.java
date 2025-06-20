package com.hari.springprojects.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hari.springprojects.dto.CustomerDTO;
import com.hari.springprojects.entity.Customer;
import com.hari.springprojects.exception.CustomerNotFoundException;
import com.hari.springprojects.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer saveCustomer(CustomerDTO customerDTO) {
		return customerRepository.save(CustomerDTO.prepareCustomer(customerDTO));
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomer(Integer customerId) throws CustomerNotFoundException {
		Customer customer = customerRepository.findByCustomerId(customerId);
		if (customer != null) {
			return customer;
		}else {
			throw new CustomerNotFoundException("No Customer found with Id " + customerId);
		}
	}

}

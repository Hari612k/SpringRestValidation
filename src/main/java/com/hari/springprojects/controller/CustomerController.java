package com.hari.springprojects.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hari.springprojects.dto.CustomerDTO;
import com.hari.springprojects.entity.Customer;
import com.hari.springprojects.exception.CustomerNotFoundException;
import com.hari.springprojects.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/signup")
	public ResponseEntity<Customer> saveCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
		return new ResponseEntity<Customer>(customerService.saveCustomer(customerDTO), HttpStatus.CREATED);
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomers(), HttpStatus.CREATED);
	}
	
	@GetMapping("/fetch/{customerId}")
	public ResponseEntity<Customer> fetchCustomer(@PathVariable Integer customerId) throws CustomerNotFoundException {
		return new ResponseEntity<Customer>(customerService.getCustomer(customerId), HttpStatus.CREATED);
	}

}

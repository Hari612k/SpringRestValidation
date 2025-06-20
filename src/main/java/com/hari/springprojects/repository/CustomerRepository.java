package com.hari.springprojects.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hari.springprojects.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Customer findByCustomerId(Integer customerId);

}

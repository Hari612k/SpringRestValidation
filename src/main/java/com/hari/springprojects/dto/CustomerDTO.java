package com.hari.springprojects.dto;

import com.hari.springprojects.entity.Customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CustomerDTO {
	
	@NotNull(message = "Customer name should not be null")
	@NotEmpty(message = "Customer name should not be null")
	private String name;
	
	@Email
	private String email;
	
	@NotNull
	private String gender;
	
	@Min(18)
	@Max(60)
	private Integer age;
	
	@NotBlank(message = "Nationality should not be blank")
	private String nationality;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	
	public static Customer prepareCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		customer.setName(customerDTO.getName());
		customer.setEmail(customerDTO.getEmail());
		customer.setAge(customerDTO.getAge());
		customer.setGender(customerDTO.getGender());
		customer.setNationality(customerDTO.getNationality());
		return customer;
	}
	
	

}

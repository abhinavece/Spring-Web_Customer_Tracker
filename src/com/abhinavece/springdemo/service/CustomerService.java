package com.abhinavece.springdemo.service;

import java.util.List;

import com.abhinavece.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> listCustomer();

	public void addCustomer(Customer theCustomer);

	public Customer getCustomerById(int custId);

	public void deleteCustomer(Customer theCustomer);

	public List<Customer> searchCustomerByName(String searchName);

}
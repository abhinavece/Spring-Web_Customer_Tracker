package com.abhinavece.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhinavece.springdemo.dao.CustomerDAO;
import com.abhinavece.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> listCustomer() {
		return customerDAO.listCustomer();
	}

	@Override
	@Transactional
	public void addCustomer(Customer theCustomer) {
		customerDAO.addCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomerById(int custId) {		
		return customerDAO.getCustomerById(custId);
	}

	@Override
	@Transactional
	public void deleteCustomer(Customer theCustomer) {
		customerDAO.deleteCustomer(theCustomer);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomerByName(String searchName) {
		return customerDAO.searchCustomerByName(searchName);
	}

}

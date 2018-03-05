package com.abhinavece.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.abhinavece.springdemo.entity.Customer;
import com.abhinavece.springdemo.service.CustomerService;
import com.sun.org.apache.xpath.internal.operations.Mod;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// Injected customerService instead CustomerDAO directly
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		// Get customers from the service
		List<Customer> customers = customerService.listCustomer();
		theModel.addAttribute("customerList", customers);
		return "list-customers";

	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer newCustomer) {

		// save the customer
		customerService.addCustomer(newCustomer);
		return "redirect:/customer/list";
	}

	@RequestMapping(value = { "/showFormForUpdate" }, method = RequestMethod.GET)
	public String updateCustomer(@RequestParam("customerId") int custId, Model theModel) {

		// fetch the customer through it's ID
		Customer selectedCustomer = customerService.getCustomerById(custId);

		// Set customer as model attribute and pre-populate the form and update
		theModel.addAttribute("customer", selectedCustomer);

		// send over to our form
		return "customer-form";
	}

	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
	public String deleteCustomer(@RequestParam("customerId") int id, Model theModel) {

		Customer theCustomer = customerService.getCustomerById(id);

		theModel.addAttribute(theCustomer);

		return "delete-customer";
	}

	@PostMapping("/deleteCustomer")
	public String deleteCustomer(@ModelAttribute("customer") Customer newCustomer) {

		// delete the customer
		customerService.deleteCustomer(newCustomer);

		return "redirect:/customer/list";
	}

	@RequestMapping(value = "/searchCustomer", method = RequestMethod.GET)
	public String searchCustomerByName(@ModelAttribute("theSearchName") String searchName, Model theModel) {

		List<Customer> searchedCustomer = customerService.searchCustomerByName(searchName);
		theModel.addAttribute("customerList", searchedCustomer);

		return "list-customers";
	}

}

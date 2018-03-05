package com.abhinavece.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abhinavece.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> listCustomer() {

		Session currentSession = sessionFactory.getCurrentSession();

		// Create a query
		Query<Customer> theQuery = currentSession.createQuery("FROM Customer", Customer.class);

		// Execute the query
		List<Customer> customers = theQuery.getResultList();

		// return the results
		return customers;
	}

	@Override
	public void addCustomer(Customer theCustomer) {

		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomerById(int custId) {

		// get the currentSession object
		Session currentSession = sessionFactory.getCurrentSession();

		// fetch the customerObject using primary key ID
		Customer cust = currentSession.get(Customer.class, custId);

		return cust;

	}

	@Override
	public void deleteCustomer(Customer theCustomer) {

		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.delete(theCustomer);

	}

	@Override
	public List<Customer> searchCustomerByName(String theSearchName) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = null;

		//
		// only search by name if theSearchName is not empty
		//
		if (theSearchName != null && theSearchName.trim().length() > 0) {

			// search for firstName or lastName ... case insensitive
			theQuery = currentSession.createQuery(
					"from Customer where lower(firstName) like :theName or lower(lastName) like :theName",
					Customer.class);
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

		} else {
			// theSearchName is empty ... so just get all customers
			theQuery = currentSession.createQuery("from Customer", Customer.class);
		}

		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();

		// return the results

		return customers;
	}

}

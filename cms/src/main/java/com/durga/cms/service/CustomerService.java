package com.durga.cms.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durga.cms.dao.CustomerRepository;
import com.durga.cms.exceptions.CustomerNotFoundException;
import com.durga.cms.model.Customer;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	

	public Customer addCustomer(Customer customer) {
		
		return customerRepository.save(customer);
	}

	public List<Customer> getCustomers() {
		
		return customerRepository.findAll();
	}

	public Customer getCustomerById(int id) {
		
		 Optional<Customer> optionalCustomer=customerRepository.findById(id);
		 if(!optionalCustomer.isPresent())
		 {
			  throw new CustomerNotFoundException("customer is not found with the id "+id);
		 }
		 return optionalCustomer.get();
	
		
	}

	public Customer updateCustomer(int customerId, Customer customer) {

		
		customer.setCustomerId(customerId);
		return customerRepository.save(customer);
	}

	public void delteCustomer(int customerId) {
		
		customerRepository.deleteById(customerId);
	}
}

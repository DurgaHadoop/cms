package com.durga.cms.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.durga.cms.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

	@Override
	 List<Customer> findAll();
		
}

package org.efood.restraunt.dao;

import java.util.List;

import org.efood.restraunt.dto.Customer;
import org.efood.restraunt.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {
	
	@Autowired
	CustomerRepository customerRepository;

	public Customer fetchByEmail(String email) {
		
		return customerRepository.findByEmail(email) ;
	}

	public Customer fetchByMobile(long mobile) {
		
		return customerRepository.findByMobile(mobile);
	}

	public Customer save(Customer customer) {
		return customerRepository.save(customer);
		
	}

	public Customer fetchById(int id) {
		
		return customerRepository.findById(id).orElse(null);
	}

	public List<Customer> fetchAll() {
		
		return customerRepository.findAll();
	}

}

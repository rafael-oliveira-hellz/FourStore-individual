package br.com.foursys.fourcamp.fourstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.foursys.fourcamp.fourstore.data.CustomerData;
import br.com.foursys.fourcamp.fourstore.model.Customer;

@Service
public class CustomerService {
	@Autowired
	private CustomerData customerData;
	
	public List<Customer> findAll() {
		return customerData.findAll();
	}
	
	public Customer findById(Long id) {
		Optional<Customer> obj = customerData.findById(id);
		return obj.get();
	}
	
	public Customer create(Customer customer) {
		return customerData.save(customer);
	}
	
	public void delete(Long id ) {
		customerData.deleteById(id);
	}
}

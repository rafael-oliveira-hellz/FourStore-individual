package br.com.foursys.fourcamp.fourstore.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.foursys.fourcamp.fourstore.model.Customer;
import br.com.foursys.fourcamp.fourstore.service.CustomerService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public ResponseEntity<List<Customer>> findAll() {
		List<Customer> list = customerService.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity <Customer> findById(@PathVariable Long id) {
		Customer customer = customerService.findById(id);
		
		return ResponseEntity.ok().body(customer);
	}
	
	@PostMapping
	public ResponseEntity <Customer> create(@RequestBody Customer customer) {
		customer = customerService.create(customer);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(customer.getId()).toUri();
		
		return ResponseEntity.created(uri).body(customer);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity <Customer> delete(@PathVariable Long id) {
		
		customerService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}

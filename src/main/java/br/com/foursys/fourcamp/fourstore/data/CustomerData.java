package br.com.foursys.fourcamp.fourstore.data;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.foursys.fourcamp.fourstore.model.Customer;

public interface CustomerData extends JpaRepository<Customer, Long> {
	
}

package br.com.foursys.fourcamp.fourstore.test;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.foursys.fourcamp.fourstore.data.CategoryData;
import br.com.foursys.fourcamp.fourstore.data.CustomerData;
import br.com.foursys.fourcamp.fourstore.data.ProductData;
import br.com.foursys.fourcamp.fourstore.model.Category;
//import br.com.foursys.fourcamp.fourstore.model.Address;
import br.com.foursys.fourcamp.fourstore.model.Customer;
import br.com.foursys.fourcamp.fourstore.model.Product;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private CustomerData customerData;

	@Autowired
	private CategoryData categoryData;

	@Autowired
	private ProductData productData;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// Address e1 = new Address();
		Customer c1 = new Customer("João", "24-04-1986", "12345678900");
		Customer c2 = new Customer("João 2", "24-04-1986", "12345678900");

		Category cat1 = new Category("Moda Masculina");
		Category cat2 = new Category("Moda Feminina");
		Category cat3 = new Category("Moda Bebê");

		Product p1 = new Product();

		customerData.saveAll(Arrays.asList(c1, c2));
		categoryData.saveAll(Arrays.asList(cat1, cat2, cat3));
		productData.saveAll(Arrays.asList(p1));
	}
}

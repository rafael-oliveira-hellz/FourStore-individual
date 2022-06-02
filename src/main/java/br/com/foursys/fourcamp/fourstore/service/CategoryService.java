package br.com.foursys.fourcamp.fourstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.foursys.fourcamp.fourstore.data.CategoryData;
import br.com.foursys.fourcamp.fourstore.model.Category;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryData categoryData;
	
	public List<Category> findAll() {
		return categoryData.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obg = categoryData.findById(id);
		return obg.get();
	}
	
	public Category create(Category category) {
		return categoryData.save(category);
	}
	
	public void delete(Long id ) {
		categoryData.deleteById(id);
	}
}

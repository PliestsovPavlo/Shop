package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Category;

public interface CategoryService {
	
	void save(Category category);
	void delete(Long id);
	
	List<Category> findAll();
	Category findOne(Long id);
	
	Page<Category> findAll(Pageable pageable);
	Category findByNameOfCategory(String nameOfCategory);

}

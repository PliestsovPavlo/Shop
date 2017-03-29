package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.Category;
import ua.repository.CategoryRepository;
import ua.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public void save(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public void delete(Long id) {
		categoryRepository.delete(id);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findOne(Long id) {
		return categoryRepository.findOne(id);
	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

	@Override
	public Category findByNameOfCategory(String nameOfCategory) {
		return categoryRepository.findByNameOfCategory(nameOfCategory);
	}

}

package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Author;

public interface AuthorService {

	void save(Author author);
	void delete(Long id);
	
	List<Author> findAll();
	Author findOne(Long id);
	
	Page<Author> findAll(Pageable pageable);
	Author findByLastName(String lastName);
}

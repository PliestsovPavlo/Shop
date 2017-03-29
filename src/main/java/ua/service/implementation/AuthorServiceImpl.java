package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.Author;
import ua.repository.AuthorRepository;
import ua.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService{
	
	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public void save(Author author) {
		authorRepository.save(author);		
	}

	@Override
	public void delete(Long id) {

		authorRepository.delete(id);
	}

	@Override
	public List<Author> findAll() {
		return authorRepository.findAll();
	}

	@Override
	public Author findOne(Long id) {
		return authorRepository.findOne(id);
	}

	@Override
	public Page<Author> findAll(Pageable pageable) {
		return authorRepository.findAll(pageable);
	}

	@Override
	public Author findByLastName(String lastName) {
		return authorRepository.findByLastName(lastName);
	}

}

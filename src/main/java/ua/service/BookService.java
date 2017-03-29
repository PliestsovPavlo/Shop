package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Book;
import ua.form.BookForm;

public interface BookService {

	void save (BookForm bookForm);
	void delete (Long id);
	BookForm findOne(Long id);
	List<Book> findAll();
	Page<Book> findAll(Pageable pageable);
}

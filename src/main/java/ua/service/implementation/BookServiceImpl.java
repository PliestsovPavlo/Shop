package ua.service.implementation;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.Book;
import ua.form.BookForm;
import ua.repository.BookRepository;
import ua.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepository;
	
	
	@Override
	public void save(BookForm bookForm) {
		Book book = new Book();
		book.setTitle(bookForm.getTitle());
		book.setId(bookForm.getId());
		book.setPrice(new BigDecimal(bookForm.getPrice().replaceAll(",", ".")));
		book.setAuthor(bookForm.getAuthor());
		book.setCategory(bookForm.getCategory());
		bookRepository.save(book);		
	}

	@Override
	public void delete(Long id) {

		bookRepository.delete(id);
	}

	@Override
	public BookForm findOne(Long id) {
		Book book = bookRepository.findOne(id);
		BookForm bookForm = new BookForm();
		bookForm.setId(book.getId());
		bookForm.setAuthor(book.getAuthor());
		bookForm.setCategory(book.getCategory());
		bookForm.setTitle(book.getTitle());
		bookForm.setPrice(String.valueOf(book.getPrice()));
		return bookForm;
	}

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public Page<Book> findAll(Pageable pageable) {
		return bookRepository.findAll(pageable);
	}

}

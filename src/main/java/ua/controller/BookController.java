package ua.controller;

import static ua.util.ParamBuilder.buildParams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.editor.AuthorEditor;
import ua.editor.CategoryEditor;
import ua.entity.Author;
import ua.entity.Category;
import ua.form.BookForm;
import ua.service.AuthorService;
import ua.service.BookService;
import ua.service.CategoryService;

@Controller
@RequestMapping("/admin/book")
@SessionAttributes(names="bookForm")
public class BookController {
	
	@ModelAttribute("bookForm")
	public BookForm getBookForm(){
		return new BookForm();
	}
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private CategoryService categoryService;
	
	@InitBinder("bookForm")
	protected void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Author.class, new AuthorEditor(authorService));
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable){
		model.addAttribute("books", bookService.findAll(pageable));
		model.addAttribute("authors", authorService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		return "book";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, @PageableDefault Pageable pageable){
		bookService.delete(id);
		return "redirect:/admin/book"+buildParams(pageable);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model, @PageableDefault Pageable pageable){
		model.addAttribute("bookForm", bookService.findOne(id));
		show(model, pageable);
		return "book";
	}
	
	@PostMapping
	public String save(@ModelAttribute("bookForm")BookForm book, SessionStatus status,@PageableDefault Pageable pageable, Model model){
		bookService.save(book);
		status.setComplete();
		return "redirect:/admin/book"+buildParams(pageable);
	}
	

}

package ua.form;

import java.util.ArrayList;
import java.util.List;

import ua.entity.Author;
import ua.entity.Category;
import ua.entity.Order;

public class BookForm {
	
	private Long id;
	
	private String title;
	
	private String price;
	
	private Author author;
	
	private Category category;
	
	private List<Order> order = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

}

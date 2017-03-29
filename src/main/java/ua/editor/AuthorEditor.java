package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.Author;
import ua.service.AuthorService;

public class AuthorEditor extends PropertyEditorSupport{
	
	private final AuthorService authorService;

	public AuthorEditor(AuthorService authorService) {
		super();
		this.authorService = authorService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Author author = authorService.findOne(Long.valueOf(text));
		setValue(author);
	}
	
}

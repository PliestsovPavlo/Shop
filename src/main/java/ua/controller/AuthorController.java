package ua.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.entity.Author;
import ua.service.AuthorService;

import static ua.util.ParamBuilder.buildParams;

@Controller
@RequestMapping("/admin/author")
@SessionAttributes("authorForm")
public class AuthorController {
	
	@Autowired
	AuthorService authorService;
	
	@ModelAttribute("authorForm")
	public Author getForm(){
		return new Author();
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable){
		model.addAttribute("authors", authorService.findAll(pageable));
		return "author";
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model, @PageableDefault Pageable pageable){
		authorService.delete(id);
		return "redirect: /admin/author"+buildParams(pageable);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model, @PageableDefault Pageable pageable){
		model.addAttribute("authorForm", authorService.findOne(id));
		show(model,pageable);
		return "author";
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status, @PageableDefault Pageable pageable){
		status.setComplete();
		return "redirect:/admin/author"+buildParams(pageable);
	}
	
	@PostMapping()
	public String save(@ModelAttribute("authorForm") Author author, SessionStatus sessionStatus, Model model, @PageableDefault Pageable pageable){
		authorService.save(author);
		sessionStatus.setComplete();
		return "redirect: /admin/author"+buildParams(pageable);
	}

}

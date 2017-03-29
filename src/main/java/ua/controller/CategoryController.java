package ua.controller;

import static ua.util.ParamBuilder.buildParams;

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

import ua.entity.Category;
import ua.service.CategoryService;


@Controller
@RequestMapping("/admin/category")
@SessionAttributes("category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@ModelAttribute("categoryForm")
	public Category getForm(){
		return new Category();
	}

	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable){
		model.addAttribute("categories", categoryService.findAll(pageable));
		return "category";
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model, @PageableDefault Pageable pageable){
		categoryService.delete(id);
		return "redirect: admin/category"+buildParams(pageable);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model, @PageableDefault Pageable pageable){
		model.addAttribute("categoryForm", categoryService.findOne(id));
		show(model,pageable);
		return "category";
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status, @PageableDefault Pageable pageable){
		status.setComplete();
		return "redirect:/admin/category"+buildParams(pageable);
	}
	
	@PostMapping()
	public String save(@ModelAttribute("categoryForm") Category category, SessionStatus sessionStatus, Model model){
		categoryService.save(category);
		sessionStatus.setComplete();
		return "redirect: /admin/category";
	}
}

package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ua.entity.User;
import ua.service.BookService;
import ua.service.UserService;

@Controller
public class IndexController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	BookService bookService;

	@GetMapping("/")
	public String index(Model model, @PageableDefault Pageable pageable){
		model.addAttribute("books", bookService.findAll(pageable));
		model.addAttribute("user", getPrincipal());
		return "index";
	}
	
	@GetMapping("/admin")
	public String adminPage(ModelMap model){
		model.addAttribute("user", getPrincipal());
		return "/admin";
	}
	
	@GetMapping("/user")
	public String userPage(Model model, @PageableDefault Pageable pageable){
		model.addAttribute("user", getPrincipal());
		model.addAttribute("books", bookService.findAll(pageable));

		return "index";
	}
	
	@GetMapping("/login")
	public String login(Model model){
		model.addAttribute("user", getPrincipal());
		return "/login";
	}
	
	@GetMapping("/registration")
	public String registration(Model model){
		model.addAttribute("userForm", new User());
		return "/registration";
	}
	
	@PostMapping("/registration")
	public String registration(@ModelAttribute User user){
		userService.save(user);
		return "redirect:/login";
	}
	
	private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        
        System.out.println(userName);
        return userName;
    }
}

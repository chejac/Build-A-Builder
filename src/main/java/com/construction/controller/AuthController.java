package com.construction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.construction.constant.States;
import com.construction.entity.User;
import com.construction.service.SecurityService;
import com.construction.service.UserService;
import com.construction.validator.UserValidator;

@Controller
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private UserValidator userValidator;

	@GetMapping("/")
	public String home(Model model) {
		return "index";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("userForm", new User());
		model.addAttribute("states", States.getAllAbbreviations());
		
		return "auth/register";
	}
	
	@PostMapping("/register")
	public String register(Model model, @ModelAttribute("userForm") User userForm, 
			BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("states", States.getAllAbbreviations());
			
			return "auth/register";
		}
		
		userService.save(userForm);
		securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());
		
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null) {
			model.addAttribute("error", "Your username or password is invalid.");
		}
		if (logout != null) {
			model.addAttribute("loggedOut", "You have been logged out successfully.");
		}
		
		return "auth/login";
	}
	
	// PostMapping("/login") handled by Spring Security
	
	@GetMapping("/access_denied")
	public String accessDenied() {
		return "error/access_denied";
	}
	
}

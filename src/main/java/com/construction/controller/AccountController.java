package com.construction.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.construction.constant.States;
import com.construction.entity.User;
import com.construction.service.UserService;
import com.construction.validator.UserValidator;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidator userValidator;
	
	@GetMapping("/")
	public String editUserForm(Model model, Principal principal, 
			@RequestParam(required = false) String isUpdated) {
		User userForm = userService.getByUsername(principal.getName());
		model.addAttribute("userForm", userForm);
		model.addAttribute("isUpdated", isUpdated);
		model.addAttribute("states", States.getAllAbbreviations());
		
		return "user/edit_account";
	}
	
	@PostMapping("/update")
	public String updateUserForm(Model model, @ModelAttribute("userForm") User userForm,
			BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("states", States.getAllAbbreviations());
			
			return "user/edit_account";
		}
		
		userService.update(userForm);
		
		return "redirect:/account/?isUpdated=true";
	}
	
}

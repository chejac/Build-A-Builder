package com.construction.controller;

import java.security.Principal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.construction.entity.CartDetail;
import com.construction.entity.User;
import com.construction.service.CartDetailService;
import com.construction.service.CartService;
import com.construction.service.UserService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartDetailService cartDetailService;

	@GetMapping("/")
	public String cartManager(Model model, Principal principal) {
		if (principal == null) return "redirect:/login";
		
		User user = userService.getByUsername(principal.getName());
		Long cartId = user.getCart().getId();
		Set<CartDetail> cartDetails = cartService.getById(cartId).getCartDetails();
		model.addAttribute("allCartDetails", cartDetails);
		
		return "cart/cart_manager";
	}
	
	@GetMapping("/update")
	public String updateCart(@RequestParam int inputValue, @RequestParam Long cartDetailId) {
		cartDetailService.update(cartDetailId, inputValue);
		
		return "redirect:/cart/";
	}
	
	@GetMapping("/delete")
	public String deleteCart(@RequestParam Long id) {
		cartDetailService.deleteById(id);
		
		return "redirect:/cart/";
	}
	
}

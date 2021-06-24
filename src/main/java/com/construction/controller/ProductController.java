package com.construction.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.construction.entity.Product;
import com.construction.entity.User;
import com.construction.exception.ResourceNotFoundException;
import com.construction.service.ProductService;
import com.construction.service.UserService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;
	
	@GetMapping({"/", "/type"})
	public String productCatalog(Model model, @RequestParam(required = false) String productType) {
		if (productType == null) productType = "all";
		model.addAttribute("productType", productType);
		
		List<Product> allProductsByType = productService.getAllProductByType(productType);
		if (allProductsByType.isEmpty()) {
			throw new ResourceNotFoundException("Resource is not available.");
		}
		
		model.addAttribute("allProductsByType", allProductsByType);
		
		return "product/product_catalog";
	}
	
	@GetMapping("/cart")
	public String addProductToCart(Principal principal, @RequestParam Long productId, 
			@RequestParam int quantityOrdered) {
		if (principal == null) return "redirect:/login";
		
		User user = userService.getByUsername(principal.getName());
		userService.addToCart(user, productId, quantityOrdered);
		
		return "redirect:/cart/";
	}
	
	@GetMapping("/search")
	public String searchProduct(Model model, @RequestParam String productName) {
		model.addAttribute("productType", "Searched");
		
		List<Product> allProductsBySearch = productService.getAllProductBySearch(productName);
		if (allProductsBySearch.isEmpty()) {
			throw new ResourceNotFoundException("Resource is not available.");
		}
		
		model.addAttribute("allProductsByType", allProductsBySearch);
		
		return "product/product_catalog";
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFoundException() {
        return "error/not_found";
    }
	
}

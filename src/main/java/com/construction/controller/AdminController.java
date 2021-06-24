package com.construction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.construction.entity.Product;
import com.construction.service.OrderService;
import com.construction.service.ProductService;
import com.construction.service.ProductTypeService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductTypeService productTypeService;
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/")
	public String adminPrivilege(Model model, 
			@RequestParam(required = false) String isUpdated) {
		model.addAttribute("allProducts", productService.getAll());
		model.addAttribute("allOrders", orderService.getAll());
		model.addAttribute("isUpdated", isUpdated);
		
		return "admin/admin_privilege";
	}
	
	@GetMapping("/product/new")
	public String addProductForm(Model model) {
		model.addAttribute("productForm", new Product());
		model.addAttribute("allProductTypes", productTypeService.getAllName());
		
		return "admin/new_product";
	}
	
	@PostMapping("/product/add")
	public String addProductForm(@ModelAttribute Product productForm) {
		productService.save(productForm);
		
		return "redirect:/admin/?isUpdated=added";
	}
	
	@GetMapping("/product/edit")
	public String editProductForm(Model model, @RequestParam Long id) {
		model.addAttribute("productForm", productService.getById(id));
		model.addAttribute("allProductTypes", productTypeService.getAllName());
		
		return "admin/edit_product";
	}
	
	@PostMapping("/product/update")
	public String updateProductForm(@ModelAttribute Product productForm) {
		productService.update(productForm);
		
		return "redirect:/admin/?isUpdated=updated";
	}
	
	@GetMapping("/product/delete")
	public String deleteProductForm(@RequestParam Long id) {
		productService.deleteById(id);
		
		return "redirect:/admin/?isUpdated=deleted";
	}
	
}

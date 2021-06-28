package com.construction.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.construction.entity.Order;
import com.construction.entity.User;
import com.construction.service.OrderService;
import com.construction.service.UserService;
import com.construction.validator.OrderValidator;

/**
 * Controller for the order pages
 * @author Jack Chen
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderValidator orderValidator;
	
	/**
	 * Bind the formatted date to the entity
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

	/**
	 * View all orders of the user
	 * @param model
	 * @param principal
	 * @return jsp
	 */
	@GetMapping("/")
	public String orderManager(Model model, Principal principal) {
		User user = userService.getByUsername(principal.getName());
		model.addAttribute("orders", orderService.getByUserId(user.getId()));
		
		return "order/order_manager";
	}
	
	/**
	 * Update the order
	 * @param model
	 * @param id
	 * @return jsp
	 */
	@GetMapping("/update")
	public String updateOrder(Model model, @RequestParam Long id) {
		model.addAttribute("orderForm", orderService.getById(id));
		
		return "order/edit_order";
	}
	
	/**
	 * Add the updated order in the database
	 * @param principal
	 * @param orderForm
	 * @param bindingResult
	 * @return redirect
	 */
	@PostMapping("/update")
	public String processOrder(Principal principal, @ModelAttribute("orderForm") Order orderForm,
			BindingResult bindingResult) {
		orderValidator.validate(orderForm, bindingResult);
		
		if (bindingResult.hasErrors()) return "order/edit_order";
		
		User user = userService.getByUsername(principal.getName());
		orderService.updateOrder(orderForm, user);
		
		return "redirect:/order/";
	}
	
	/**
	 * Cancel the order
	 * @param id
	 * @return redirect
	 */
	@GetMapping("/cancel")
	public String cancelOrder(@RequestParam Long id) {
		orderService.cancelOrder(id);
		
		return "redirect:/order/";
	}
	
}

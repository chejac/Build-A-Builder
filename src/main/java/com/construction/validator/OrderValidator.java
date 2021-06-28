package com.construction.validator;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.construction.entity.Order;

@Component
public class OrderValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Order.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Order order = (Order) target;
		
		Date orderDate = order.getOrderDate();
		
		if (orderDate == null) orderDate = new Date();
		
		if (orderDate.after(order.getReturnDate())) {
			errors.rejectValue("returnDate", "Time.orderForm.returnDate");
		}
	}

	
	
}

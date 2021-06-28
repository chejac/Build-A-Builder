package com.construction.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construction.entity.Order;
import com.construction.entity.ProductDetail;
import com.construction.entity.User;
import com.construction.repository.OrderRepository;

@Service
public class OrderService {

	private OrderRepository orderRepo;
	
	@Autowired
	public OrderService(OrderRepository orderRepo) {
		this.orderRepo = orderRepo;
	}
	
	public void save(Order order) {
		orderRepo.save(order);
	}
	
	public List<Order> getAll() {
		return (List<Order>) orderRepo.findAll();
	}
	
	public Order getById(Long id) {
		return orderRepo.findById(id).get();
	}
	
	public List<Order> getByUserId(Long userId) {
		return orderRepo.findByUserId(userId);
	}
	
	public void addToOrder(Order order, User user) {
		double subtotal = 0;
		
		for (ProductDetail pd : user.getCart().getProductDetails()) {
			pd.setOrder(order);
			pd.setCart(null);
			subtotal += pd.getQuantityOrdered() * pd.getProduct().getDailyRentalRate();
		}
		
		long timeDifference = order.getReturnDate().getTime() - new Date().getTime();
		double durationInDays = timeDifference / (1000.0 * 60 * 60 * 24);
		
		subtotal = Math.round(100 * subtotal * durationInDays) / 100.0;
		
		order.setUser(user);
		order.setSubtotal(subtotal);
		
		orderRepo.save(order);
	}
	
	public void updateOrder(Order order, User user) {
		Order foundOrder = orderRepo.findById(order.getId()).get();
		double subtotal = 0;
		
		for (ProductDetail pd : foundOrder.getProductDetails()) {
			subtotal += pd.getQuantityOrdered() * pd.getProduct().getDailyRentalRate();
		}
		
		long timeDifference = order.getReturnDate().getTime() - foundOrder.getOrderDate().getTime();
		double durationInDays = timeDifference / (1000.0 * 60 * 60 * 24);
		
		subtotal = Math.round(100 * subtotal * durationInDays) / 100.0;
		
		foundOrder.setReturnDate(order.getReturnDate());
		foundOrder.setSubtotal(subtotal);
		
		orderRepo.save(foundOrder);
	}
	
	public void cancelOrder(Long id) {
		Order foundOrder = orderRepo.findById(id).get();
		foundOrder.setStatus("Cancelled");
		
		save(foundOrder);
	}
	
	public void update(Order order) {
		Order foundOrder = getById(order.getId());
		foundOrder.setReturnDate(order.getReturnDate());
		foundOrder.setStatus(order.getStatus());
		
		orderRepo.save(foundOrder);
	}
	
	public void delete(Order order) {
		orderRepo.delete(order);
	}
	
	public void deleteById(Long id) {
		orderRepo.deleteById(id);
	}
	
}

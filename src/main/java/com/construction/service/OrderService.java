package com.construction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construction.entity.Order;
import com.construction.entity.OrderDetail;
import com.construction.repository.OrderDetailRepository;
import com.construction.repository.OrderRepository;

@Service
public class OrderService {

	private OrderRepository orderRepo;
	
	private OrderDetailRepository orderDetailRepo;
	
	@Autowired
	public OrderService(OrderRepository orderRepo, 
			OrderDetailRepository orderDetailRepo) {
		this.orderRepo = orderRepo;
		this.orderDetailRepo = orderDetailRepo;
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
	
	public void update(Order order) {
		Order foundOrder = getById(order.getId());
		foundOrder.setReturnDate(order.getReturnDate());
		foundOrder.setStatus(order.getStatus());
		
		orderRepo.save(foundOrder);
	}
	
	public void addOrderDetail(Long orderId, Long orderDetailId) {
		Order foundOrder = getById(orderId);
		OrderDetail foundOD = orderDetailRepo.findById(orderDetailId).get();
		foundOrder.getOrderDetails().add(foundOD);
		
		orderRepo.save(foundOrder);
	}
	
	public void delete(Order order) {
		orderRepo.delete(order);
	}
	
	public void deleteById(Long id) {
		orderRepo.deleteById(id);
	}
	
}

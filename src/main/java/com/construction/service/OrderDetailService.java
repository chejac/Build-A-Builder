package com.construction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construction.entity.OrderDetail;
import com.construction.repository.OrderDetailRepository;

@Service
public class OrderDetailService {

	private OrderDetailRepository orderDetailRepo;
	
	@Autowired
	public OrderDetailService(OrderDetailRepository orderDetailRepo) {
		this.orderDetailRepo = orderDetailRepo;
	}
	
	public void save(OrderDetail od) {
		orderDetailRepo.save(od);
	}
	
	public List<OrderDetail> getAll() {
		return (List<OrderDetail>) orderDetailRepo.findAll();
	}
	
	public OrderDetail getById(Long id) {
		return orderDetailRepo.findById(id).get();
	}
	
	public void update(OrderDetail od) {
		OrderDetail foundOD = getById(od.getId());
		foundOD.setQuantityOrdered(od.getQuantityOrdered());
		
		orderDetailRepo.save(foundOD);
	}
	
	public void delete(OrderDetail od) {
		orderDetailRepo.delete(od);
	}
	
	public void deleteById(Long id) {
		orderDetailRepo.deleteById(id);
	}
	
}

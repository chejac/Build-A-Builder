package com.construction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construction.entity.CartDetail;
import com.construction.repository.CartDetailRepository;

@Service
public class CartDetailService {

	private CartDetailRepository cartDetailRepo;
	
	@Autowired
	public CartDetailService(CartDetailRepository cartDetailRepo) {
		this.cartDetailRepo = cartDetailRepo;
	}
	
	public void save(CartDetail cd) {
		cartDetailRepo.save(cd);
	}
	
	public List<CartDetail> getAll() {
		return (List<CartDetail>) cartDetailRepo.findAll();
	}
	
	public CartDetail getById(Long id) {
		return cartDetailRepo.findById(id).get();
	}
	
	public void update(CartDetail cd) {
		CartDetail foundCD = getById(cd.getId());
		foundCD.setQuantityOrdered(cd.getQuantityOrdered());
		
		cartDetailRepo.save(foundCD);
	}
	
	public void update(Long cartDetailId, int quantityOrdered) {
		CartDetail foundCD = getById(cartDetailId);
		foundCD.setQuantityOrdered(quantityOrdered);
		
		cartDetailRepo.save(foundCD);
	}
	
	public void delete(CartDetail cd) {
		cartDetailRepo.delete(cd);
	}
	
	public void deleteById(Long id) {
		cartDetailRepo.deleteById(id);
	}
	
}

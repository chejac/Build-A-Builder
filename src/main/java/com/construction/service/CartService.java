package com.construction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construction.entity.Cart;
import com.construction.repository.CartRepository;

@Service
public class CartService {

	private CartRepository cartRepo;
	
	@Autowired
	public CartService(CartRepository cartRepo) {
		this.cartRepo = cartRepo;
	}
	
	public void save(Cart cart) {
		cartRepo.save(cart);
	}
	
	public List<Cart> getAll() {
		return (List<Cart>) cartRepo.findAll();
	}
	
	public Cart getById(Long id) {
		return cartRepo.findById(id).get();
	}
	
	public void delete(Cart cart) {
		cartRepo.delete(cart);
	}
	
	public void deleteById(Long id) {
		cartRepo.deleteById(id);
	}
	
}

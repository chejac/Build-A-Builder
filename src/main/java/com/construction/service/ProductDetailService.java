package com.construction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construction.entity.Cart;
import com.construction.entity.Product;
import com.construction.entity.ProductDetail;
import com.construction.entity.User;
import com.construction.repository.ProductDetailRepository;
import com.construction.repository.ProductRepository;

@Service
public class ProductDetailService {

	private ProductRepository productRepo;
	
	private ProductDetailRepository productDetailRepo;
	
	@Autowired
	public ProductDetailService(ProductRepository productRepo, 
			ProductDetailRepository productDetailRepo) {
		this.productRepo = productRepo;
		this.productDetailRepo = productDetailRepo;
	}
	
	public void save(ProductDetail pd) {
		productDetailRepo.save(pd);
	}
	
	public List<ProductDetail> getAll() {
		return (List<ProductDetail>) productDetailRepo.findAll();
	}
	
	public ProductDetail getById(Long id) {
		return productDetailRepo.findById(id).get();
	}
	
	public void addToCart(User user, Long productId, int quantityOrdered) {
		Cart foundCart = user.getCart();
		ProductDetail foundProductDetail = productDetailRepo.findByCartIdAndProductId(foundCart.getId(), productId);
		
		if (foundProductDetail == null) {
			foundProductDetail = new ProductDetail();
			Product foundProduct = productRepo.findById(productId).get();
			foundProductDetail.setProduct(foundProduct);
			foundProductDetail.setCart(foundCart);
		}
		
		foundProductDetail.setQuantityOrdered(foundProductDetail.getQuantityOrdered() + quantityOrdered);
		
		productDetailRepo.save(foundProductDetail);
	}
	
	public void update(ProductDetail pd) {
		ProductDetail foundCD = getById(pd.getId());
		foundCD.setQuantityOrdered(pd.getQuantityOrdered());
		
		productDetailRepo.save(foundCD);
	}
	
	public void update(Long productDetailId, int quantityOrdered) {
		ProductDetail foundPD = getById(productDetailId);
		foundPD.setQuantityOrdered(quantityOrdered);
		
		productDetailRepo.save(foundPD);
	}
	
	public void delete(ProductDetail pd) {
		productDetailRepo.delete(pd);
	}
	
	public void deleteById(Long id) {
		productDetailRepo.deleteById(id);
	}
	
}

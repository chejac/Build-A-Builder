package com.construction.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construction.entity.Product;
import com.construction.entity.ProductType;
import com.construction.repository.ProductRepository;
import com.construction.repository.ProductTypeRepository;

@Service
public class ProductService {

	private ProductRepository productRepo;
	
	private ProductTypeRepository productTypeRepo;
	
	@Autowired
	public ProductService(ProductRepository productRepo, ProductTypeRepository productTypeRepo) {
		this.productRepo = productRepo;
		this.productTypeRepo = productTypeRepo;
	}
	
	public void save(Product product) {
		product.setQuantityInStock(product.getTotalQuantity());
		ProductType pt = productTypeRepo.findByNameIgnoreCase(product.getProductType().getName());
		product.setProductType(pt);
		
		productRepo.save(product);
	}
	
	public List<Product> getAll() {
		return (List<Product>) productRepo.findAll();
	}
	
	public List<Product> getAllProductByType(String name) {
		List<Product> allProducts = (List<Product>) productRepo.findAll();
		if (name.equals("all")) return allProducts;
		
		List<Product> productsByType = new ArrayList<>();
		for (Product product : allProducts) {
			String productName = product.getProductType().getName().toLowerCase();
			if (productName.equals(name.toLowerCase())) productsByType.add(product);
		}
		
		return productsByType;
	}
	
	public List<Product> getAllProductBySearch(String name) {
		return productRepo.findByNameContainingIgnoreCase(name);
	}
	
	public Product getById(Long id) {
		return productRepo.findById(id).get();
	}
	
	public void update(Product product) {
		Product foundProduct = getById(product.getId());
		foundProduct.setName(product.getName());
		foundProduct.setDescription(product.getDescription());
		foundProduct.setImage(product.getImage());
		int newTotalQuantity = product.getTotalQuantity();
		int newQuantityInStock = newTotalQuantity - 
				foundProduct.getTotalQuantity() + 
				foundProduct.getQuantityInStock();
		foundProduct.setTotalQuantity(newTotalQuantity);
		foundProduct.setQuantityInStock(newQuantityInStock);
		foundProduct.setDailyRentalRate(product.getDailyRentalRate());
		ProductType pt = productTypeRepo.findByNameIgnoreCase(product.getProductType().getName());
		foundProduct.setProductType(pt);
		
		productRepo.save(foundProduct);
	}
	
	public void delete(Product product) {
		productRepo.delete(product);
	}
	
	public void deleteById(Long id) {
		productRepo.deleteById(id);
	}
	
}

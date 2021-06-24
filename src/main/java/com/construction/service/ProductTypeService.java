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
public class ProductTypeService {

	private ProductTypeRepository productTypeRepo;
	
	private ProductRepository productRepo;
	
	@Autowired
	public ProductTypeService(ProductTypeRepository productTypeRepo, 
			ProductRepository productRepo) {
		this.productTypeRepo = productTypeRepo;
		this.productRepo = productRepo;
	}
	
	public void save(ProductType pt) {
		productTypeRepo.save(pt);
	}
	
	public List<ProductType> getAll() {
		return (List<ProductType>) productTypeRepo.findAll();
	}
	
	public List<String> getAllName() {
		List<String> names = new ArrayList<>();
		
		for (ProductType pt : getAll()) {
			names.add(pt.getName());
		}
		
		return names;
	}
	
	public ProductType getById(Long id) {
		return productTypeRepo.findById(id).get();
	}
	
	public ProductType getByName(String name) {
		return productTypeRepo.findByNameIgnoreCase(name);
	}
	
	public void update(ProductType pt) {
		ProductType foundPT = getById(pt.getId());
		foundPT.setName(pt.getName());
		foundPT.setDescription(pt.getDescription());
		foundPT.setImage(pt.getImage());
		
		productTypeRepo.save(foundPT);
	}
	
	public void addProduct(Long productTypeId, Long productId) {
		ProductType foundPT = getById(productTypeId);
		Product foundProduct = productRepo.findById(productId).get();
		foundPT.getProducts().add(foundProduct);
		
		productTypeRepo.save(foundPT);
	}
	
	public void delete(ProductType pt) {
		productTypeRepo.delete(pt);
	}
	
	public void deleteById(Long id) {
		productTypeRepo.deleteById(id);
	}
	
}

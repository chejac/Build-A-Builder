package com.construction.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.construction.entity.ProductType;

@Repository
public interface ProductTypeRepository extends CrudRepository<ProductType, Long> {

	public ProductType findByName(String name);
	
	public ProductType findByNameIgnoreCase(String name);
	
}

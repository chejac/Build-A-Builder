package com.construction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.construction.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	@Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%',?1,'%'))")
	public List<Product> findByNameContainingIgnoreCase(String name);
	
}

package com.construction.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.construction.entity.ProductDetail;

@Repository
public interface ProductDetailRepository extends CrudRepository<ProductDetail, Long> {
	
	@Query("SELECT cd FROM ProductDetail cd "
			+ "JOIN cd.cart c JOIN cd.product p "
			+ "WHERE c.id = ?1 AND p.id = ?2")
	public ProductDetail findByCartIdAndProductId(Long cartId, Long productId);

}

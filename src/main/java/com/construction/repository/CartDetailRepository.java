package com.construction.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.construction.entity.CartDetail;

public interface CartDetailRepository extends CrudRepository<CartDetail, Long> {
	
	@Query("SELECT cd FROM CartDetail cd "
			+ "JOIN cd.cart c JOIN cd.product p "
			+ "WHERE c.id = ?1 AND p.id = ?2")
	public CartDetail findByCartIdAndProductId(Long cartId, Long productId);

}

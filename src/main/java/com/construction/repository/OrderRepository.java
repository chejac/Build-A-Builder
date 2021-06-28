package com.construction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.construction.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

	@Query("SELECT o FROM Order o JOIN o.user u WHERE u.id = ?1")
	public List<Order> findByUserId(Long userId);
	
}

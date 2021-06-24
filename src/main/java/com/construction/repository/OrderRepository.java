package com.construction.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.construction.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}

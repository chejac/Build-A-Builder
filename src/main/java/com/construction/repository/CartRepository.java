package com.construction.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.construction.entity.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {

}

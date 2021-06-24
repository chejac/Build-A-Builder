package com.construction.repository;

import org.springframework.data.repository.CrudRepository;

import com.construction.entity.Cart;

public interface CartRepository extends CrudRepository<Cart, Long> {

}

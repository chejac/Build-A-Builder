package com.construction.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_details")
public class ProductDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int quantityOrdered;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id")
	private Product product;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
	private Cart cart;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
	private Order order;
	
	public ProductDetail() {}

	public ProductDetail(int quantityOrdered, Product product, Cart cart, Order order) {
		this.quantityOrdered = quantityOrdered;
		this.product = product;
		this.cart = cart;
		this.order = order;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + quantityOrdered;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDetail other = (ProductDetail) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (quantityOrdered != other.quantityOrdered)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CartDetail [id=" + id + ", quantityOrdered=" + quantityOrdered + ", product="
				+ product + "]";
	}
	
}

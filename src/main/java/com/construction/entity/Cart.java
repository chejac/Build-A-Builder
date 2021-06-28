package com.construction.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carts")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(mappedBy = "cart", optional = false)
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
	private Set<ProductDetail> productDetails;
	
	public Cart() {}

	public Cart(User user, Set<ProductDetail> productDetails) {
		this.user = user;
		this.productDetails = productDetails;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<ProductDetail> getProductDetails() {
		return productDetails;
	}

	public void setCartDetails(Set<ProductDetail> productDetails) {
		this.productDetails = productDetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productDetails == null) ? 0 : productDetails.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Cart other = (Cart) obj;
		if (productDetails == null) {
			if (other.productDetails != null)
				return false;
		} else if (!productDetails.equals(other.productDetails))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", productDetails=" + productDetails + "]";
	}
	
}

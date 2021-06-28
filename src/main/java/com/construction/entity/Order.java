package com.construction.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@CreationTimestamp
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date orderDate;
	
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date returnDate;
	
	private String status;
	
	private double subtotal;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
	private Set<ProductDetail> productDetails;
	
	public Order() {}

	public Order(Date orderDate, Date returnDate, String status, double subtotal, User user,
			Set<ProductDetail> productDetails) {
		this.orderDate = orderDate;
		this.returnDate = returnDate;
		this.status = status;
		this.subtotal = subtotal;
		this.user = user;
		this.productDetails = productDetails;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
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

	public void setProductDetails(Set<ProductDetail> productDetails) {
		this.productDetails = productDetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((productDetails == null) ? 0 : productDetails.hashCode());
		result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		long temp;
		temp = Double.doubleToLongBits(subtotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (productDetails == null) {
			if (other.productDetails != null)
				return false;
		} else if (!productDetails.equals(other.productDetails))
			return false;
		if (returnDate == null) {
			if (other.returnDate != null)
				return false;
		} else if (!returnDate.equals(other.returnDate))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (Double.doubleToLongBits(subtotal) != Double.doubleToLongBits(other.subtotal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", returnDate=" + returnDate + ", status=" + status
				+ ", subtotal=" + subtotal + ", productDetails=" + productDetails + "]";
	}
	
}

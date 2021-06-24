package com.construction.service;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.construction.entity.Cart;
import com.construction.entity.CartDetail;
import com.construction.entity.Order;
import com.construction.entity.OrderDetail;
import com.construction.entity.Product;
import com.construction.entity.Role;
import com.construction.entity.User;
import com.construction.repository.CartDetailRepository;
import com.construction.repository.CartRepository;
import com.construction.repository.ProductRepository;
import com.construction.repository.RoleRepository;
import com.construction.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepo;
	
	private RoleRepository roleRepo;
	
	private ProductRepository productRepo;
	
	private CartRepository cartRepo;
	
	private CartDetailRepository cartDetailRepo;
	
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	public UserService(UserRepository userRepo, RoleRepository roleRepo,
			ProductRepository productRepo, CartRepository cartRepo, 
			CartDetailRepository cartDetailRepo, BCryptPasswordEncoder encoder) {
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
		this.productRepo = productRepo;
		this.cartRepo = cartRepo;
		this.cartDetailRepo = cartDetailRepo;
		this.encoder = encoder;
	}
	
	public void save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setCart(new Cart());
		
		Set<Role> roles = new HashSet<>();
		Role roleUser = roleRepo.findByNameIgnoreCase("USER");
		if (roleUser == null) roleUser = new Role("USER");
		roles.add(roleUser);
		
		user.setRoles(roles);
		
		userRepo.save(user);
	}
	
	public List<User> getAll() {
		return (List<User>) userRepo.findAll();
	}
	
	public User getById(Long id) {
		return userRepo.findById(id).get();
	}
	
	public User getByUsername(String username) {
		return userRepo.findByUsernameIgnoreCase(username);
	}
	
	public User getByEmail(String email) {
		return userRepo.findByEmailIgnoreCase(email);
	}
	
	public void update(User user) {
		User foundUser = getById(user.getId());
		foundUser.setCompanyName(user.getCompanyName());
		foundUser.setFirstName(user.getFirstName());
		foundUser.setLastName(user.getLastName());
		foundUser.setPhone(user.getPhone());
		foundUser.setEmail(user.getEmail());
		foundUser.setUsername(user.getUsername());
		foundUser.setPassword(encoder.encode(user.getPassword()));
		foundUser.setPersonalInfo(user.getPersonalInfo());
		
		userRepo.save(foundUser);
	}
	
	public void addToCart(User user, Long productId, int quantityOrdered) {
		Cart foundCart = user.getCart();
		CartDetail foundCartDetail = cartDetailRepo.findByCartIdAndProductId(foundCart.getId(), productId);
		
		if (foundCartDetail == null) {
			foundCartDetail = new CartDetail();
			Product foundProduct = productRepo.findById(productId).get();
			foundCartDetail.setProduct(foundProduct);
			foundCartDetail.setCart(foundCart);
		}
		foundCartDetail.setQuantityOrdered(foundCartDetail.getQuantityOrdered() + quantityOrdered);
		
		cartDetailRepo.save(foundCartDetail);
	}
	
	public void addOrder(Long userId, Timestamp returnDate) {
		User foundUser = getById(userId);
		Set<CartDetail> cartDetails = foundUser.getCart().getCartDetails();
		Set<OrderDetail> orderDetails = new HashSet<>();
		
		for (CartDetail cd : cartDetails) {
			OrderDetail newOrderDetail = new OrderDetail();
			newOrderDetail.setQuantityOrdered(cd.getQuantityOrdered());
			newOrderDetail.setProduct(cd.getProduct());
			orderDetails.add(newOrderDetail);
		}
		
		Order newOrder = new Order();
		newOrder.setReturnDate(returnDate);
		newOrder.setStatus("In Process");
		newOrder.setOrderDetails(orderDetails);
		foundUser.getOrders().add(newOrder);
		
		cartRepo.delete(foundUser.getCart());
		foundUser.setCart(new Cart());
		
		userRepo.save(foundUser);
	}
	
	public void addRole(Long userId, String name) {
		User foundUser = getById(userId);
		Role foundRole = roleRepo.findByNameIgnoreCase(name);
		foundUser.getRoles().add(foundRole);
		
		userRepo.save(foundUser);
	}
	
	public void delete(User user) {
		userRepo.delete(user);
	}
	
	public void deleteById(Long id) {
		userRepo.deleteById(id);
	}
	
}

package com.construction.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.construction.entity.Cart;
import com.construction.entity.Role;
import com.construction.entity.User;
import com.construction.repository.RoleRepository;
import com.construction.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepo;
	
	private RoleRepository roleRepo;
	
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	public UserService(UserRepository userRepo, RoleRepository roleRepo,
			BCryptPasswordEncoder encoder) {
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
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

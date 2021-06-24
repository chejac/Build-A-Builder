package com.construction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construction.entity.Role;
import com.construction.repository.RoleRepository;

@Service
public class RoleService {

	private RoleRepository roleRepo;
	
	@Autowired
	public RoleService(RoleRepository roleRepo) {
		this.roleRepo = roleRepo;
	}
	
	public void save(Role role) {
		roleRepo.save(role);
	}
	
	public List<Role> getAll() {
		return (List<Role>) roleRepo.findAll();
	}
	
	public Role getById(Long id) {
		return roleRepo.findById(id).get();
	}
	
	public Role getByName(String name) {
		return roleRepo.findByNameIgnoreCase(name);
	}
 	
	public void update(Role role) {
		Role foundRole = getById(role.getId());
		foundRole.setName(role.getName());
		
		roleRepo.save(foundRole);
	}
	
	public void delete(Role role) {
		roleRepo.delete(role);
	}
	
	public void deleteById(Long id) {
		roleRepo.deleteById(id);
	}
	
}

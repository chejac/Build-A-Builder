package com.construction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construction.entity.PersonalInfo;
import com.construction.repository.PersonalInfoRepository;

@Service
public class PersonalInfoService {

	private PersonalInfoRepository personalInfoRepo;
	
	@Autowired
	public PersonalInfoService(PersonalInfoRepository personalInfoRepo) {
		this.personalInfoRepo = personalInfoRepo;
	}
	
	public void save(PersonalInfo ci) {
		personalInfoRepo.save(ci);
	}
	
	public List<PersonalInfo> getAll() {
		return (List<PersonalInfo>) personalInfoRepo.findAll();
	}
	
	public PersonalInfo getById(Long id) {
		return personalInfoRepo.findById(id).get();
	}
	
	public void update(PersonalInfo ci) {
		PersonalInfo foundCI = getById(ci.getId());
		foundCI.setAddressLine1(ci.getAddressLine1());
		foundCI.setAddressLine2(ci.getAddressLine2());
		foundCI.setCity(ci.getCity());
		foundCI.setState(ci.getState());
		foundCI.setPostalCode(ci.getPostalCode());
		
		personalInfoRepo.save(foundCI);
	}
	
	public void delete(PersonalInfo ci) {
		personalInfoRepo.delete(ci);
	}
	
	public void deleteById(Long id) {
		personalInfoRepo.deleteById(id);
	}
	
}

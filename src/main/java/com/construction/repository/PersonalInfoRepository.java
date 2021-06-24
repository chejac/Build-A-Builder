package com.construction.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.construction.entity.PersonalInfo;

@Repository
public interface PersonalInfoRepository extends CrudRepository<PersonalInfo, Long> {

}

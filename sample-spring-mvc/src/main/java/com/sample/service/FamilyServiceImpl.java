package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dao.FamilyDao;
import com.sample.model.Family_Members;

@Service
public class FamilyServiceImpl implements FamilyService{

	@Autowired
	FamilyDao familyDao;

	@Override
	public List<Family_Members> getListAllMembers() {
		return familyDao.getListAllMembers();
	}

	/*@Override
	public List<Family_Members> getFamilyMembers() {
		return familyDao.getFamilyMembers();
	}*/

	@Override
	public int save(Family_Members f) {
		
		return familyDao.save(f);
	}

	@Override
	public Family_Members getFamilyById(int id) {
		return familyDao.getFamilyById(id);
	}

	@Override
	public int update(Family_Members f) {
		return familyDao.update(f);
	}

	@Override
	public int delete(int id) {
		return familyDao.delete(id);
	}
	
}

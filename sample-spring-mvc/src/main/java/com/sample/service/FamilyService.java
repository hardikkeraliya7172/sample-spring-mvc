package com.sample.service;

import java.util.List;

import com.sample.model.Family_Members;

public interface FamilyService {
public List<Family_Members> getListAllMembers();
	
//public List<Family_Members> getFamilyMembers();

public int save(Family_Members f);

public Family_Members getFamilyById(int id);

public int update(Family_Members f);

public int delete(int id);

}

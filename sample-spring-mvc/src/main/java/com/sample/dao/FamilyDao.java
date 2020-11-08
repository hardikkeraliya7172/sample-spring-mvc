package com.sample.dao;

import java.util.List;


import com.sample.model.Family_Members;

public interface FamilyDao {
	//public List<Family_Members> getFamilyMembers();
	
	public List<Family_Members> getListAllMembers();
	
	public int save(Family_Members f);
	
	public Family_Members getFamilyById(int id);
	
	public int update(Family_Members f);
	
	public int delete(int id);
}

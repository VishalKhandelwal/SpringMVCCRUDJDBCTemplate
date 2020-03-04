package com.vk.dao;

import java.util.List;

import com.vk.model.PersonLeave;



public interface PersonLeaveDAO {

	
	public void addPersonLeave(PersonLeave p);
	public List<PersonLeave> listPersonsLeaves();
	public PersonLeave getPersonLeaveById(int id);
	public void removePersonLeave(int id);


}

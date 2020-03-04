package com.vk.service;

import java.util.List;

import com.vk.model.PersonLeave;


public interface PersonLeaveService {

	
	public void addPersonLeave(PersonLeave p);
	public List<PersonLeave> listPersonsLeaves();
	public PersonLeave getPersonLeaveById(int id);
	public void removePersonLeave(int id);

}

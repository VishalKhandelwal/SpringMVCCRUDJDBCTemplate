package com.vk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vk.dao.PersonLeaveDAO;
import com.vk.model.PersonLeave;



@Service
public class PersonLeaveServiceImpl implements PersonLeaveService {
	
	@Autowired
	private PersonLeaveDAO personLeaveDAO;

	/*public void setPersonLeaveDAO(PersonLeaveDAO personLeaveDAO) {
		this.personLeaveDAO = personLeaveDAO;
	}*/


	@Override
	@Transactional
	public void addPersonLeave(PersonLeave pl) {
			this.personLeaveDAO.addPersonLeave(pl);
		}	

	@Override
	@Transactional
	public List<PersonLeave> listPersonsLeaves() {
			return this.personLeaveDAO.listPersonsLeaves();
		}	

	@Override
	@Transactional
	public PersonLeave getPersonLeaveById(int id) {
			return this.personLeaveDAO.getPersonLeaveById(id);
		}
	

	@Transactional
	@Override
	public void removePersonLeave(int id) {
			this.personLeaveDAO.removePersonLeave(id);
		}
	}


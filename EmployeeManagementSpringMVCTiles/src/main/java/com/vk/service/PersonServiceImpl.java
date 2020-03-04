package com.vk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vk.dao.PersonDAO;
import com.vk.model.Person;


@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDAO personDAO;

	/*public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}*/

	@Override
	@Transactional
	public void addPerson(Person p) {
		this.personDAO.addPerson(p);
	}

	@Override
	@Transactional
	public void updatePerson(Person p) {
		this.personDAO.updatePerson(p);
	}

	@Override
	@Transactional
	public List<Person> listPersons() {
		return this.personDAO.listPersons();
	}

	@Override
	@Transactional
	public Person getPersonById(int id) {
		return this.personDAO.getPersonById(id);
	}

	@Override
	@Transactional
	public void removePerson(int id) {
		this.personDAO.removePerson(id);
	}

	@Override
	public Person getPersonDetailsByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return personDAO.getPersonDetailsByEmailAndPassword(email, password);
	}
}


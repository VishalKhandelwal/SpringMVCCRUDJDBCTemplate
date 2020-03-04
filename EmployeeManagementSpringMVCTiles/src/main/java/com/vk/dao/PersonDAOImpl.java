package com.vk.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vk.model.Person;




@Repository
public class PersonDAOImpl implements PersonDAO {
		
	@Autowired
	private SessionFactory sessionFactory;
		
	@Override
	public void addPerson(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		//logger.info("Person saved successfully, Person Details="+p);
	}

	@Override
	public void updatePerson(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		//logger.info("Person updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> listPersons() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Person> personsList = session.createQuery("from Person").list();
		for(Person p : personsList){
			//logger.info("Person List::"+p);
		}
		return personsList;
	}

	@Override
	public Person getPersonById(int id) {
		//Session session = this.sessionFactory.getCurrentSession();		
		//Person p = (Person) session.load(Person.class, new Integer(id));
		Person p = (Person) sessionFactory.getCurrentSession().get(Person.class, id);
		
		//logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void removePerson(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person) session.load(Person.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		//logger.info("Person deleted successfully, person details="+p);
	}


	
	@Override
	public Person getPersonDetailsByEmailAndPassword(String email,String password) {
		  Transaction transaction = null;
	        Person person = null;
	        try (Session session = sessionFactory.openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            person  = (Person) session.createQuery("FROM Person P WHERE P.email = :email").setParameter("email", email)
	                .uniqueResult();

	            if (person != null && person.getPassword().equals(password)) {
	                return person;
	            }
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return null;
	}
	

	
	
}

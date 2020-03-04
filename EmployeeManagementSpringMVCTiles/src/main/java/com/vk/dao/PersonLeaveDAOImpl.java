package com.vk.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vk.model.PersonLeave;



@Repository
public class PersonLeaveDAOImpl implements PersonLeaveDAO {
	
	//private static final Logger logger = LoggerFactory.getLogger(PersonLeaveDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	/*public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}*/

	@Override
	public void addPersonLeave(PersonLeave pl) {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(pl);
			//logger.info("Person Leave saved successfully, Person Details="+pl);
		}

	@Override
	@SuppressWarnings("unchecked")
	public List<PersonLeave> listPersonsLeaves() {
			Session session = this.sessionFactory.getCurrentSession();
			List<PersonLeave> personsLeavesList = session.createQuery("from PersonLeave").list();
			for(PersonLeave pl : personsLeavesList){
				//logger.info("Persons Leave List::"+pl);
			}
			return personsLeavesList;
		
	}

	@Override
	public PersonLeave getPersonLeaveById(int id) {
		/*Session session = this.sessionFactory.getCurrentSession();		
		PersonLeave pl = (PersonLeave) session.load(PersonLeave.class, new Integer(id));*/
		PersonLeave pl = (PersonLeave) sessionFactory.getCurrentSession().get(PersonLeave.class, id);
		//logger.info("Person Leave loaded successfully, Person details="+pl);
		return pl;
	}

	@Override
	public void removePersonLeave(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		PersonLeave pl = (PersonLeave) session.load(PersonLeave.class, new Integer(id));
		if(null != pl){
			session.delete(pl);
		}
		//logger.info("Person Leaves deleted successfully, person details="+pl);
	}

	
}

package com.hibernate.wonderland.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.wonderland.common.Constant;
import com.hibernate.wonderland.common.HelperFunction;
import com.hibernate.wonderland.persistent.Person;
import com.hibernate.wonderland.persistent.Student;
import com.hibernate.wornderland.utilities.HibernateUtil;

public class PersonImpl implements PersonDAO {

	private Transaction transaction = null;
	private SessionFactory sessionFactory = null;
	private Session session = null;

	// default constructor
	public PersonImpl() {
	}

	@Override
	public int insertPerson(Person person) {

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			// make transaction
			transaction = session.beginTransaction();
			// insert data
			session.save(person);
			// commit it
			transaction.commit();
			return Constant.SUCCESS;

		} catch (HibernateException e) {
			// rollback if exception
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
			return Constant.UNSUCCESS;
		} finally {
			// close it
			session.close();
			sessionFactory.close();
		}
	}

	@Override
	public Person retrievePersonByID(int id) {
		Person person = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			person = (Person) session.get(Student.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			// close it
			session.close();
			sessionFactory.close();
		}
		return person;
	}

	@Override
	public List<Person> retrievePersonCollection() {
		List<Person> personList = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			personList = session.createCriteria(Person.class).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			// close it
			session.close();
			sessionFactory.close();
		}
		return personList;
	}

	// using HQL, return list
	@Override
	public List<Person> retrievePersonByCourse(String course) {
		// set parameter for courseName
		List<Person> personList = null;
		try {
			// create query, table name must be match with mapping file
			String sql = "from Student s where s.course = :courseName";
			// crate session
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			personList = session.createQuery(sql)
					.setParameter("courseName", course).list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// close it
			session.close();
			sessionFactory.close();
		}

		return personList;
	}

	@Override
	public int updatePerson(int id, Student personParm) {
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			// make transaction
			transaction = session.beginTransaction();
			// load class
			Student person = (Student) session.get(Student.class, id);
			// set update fields
			/*if (HelperFunction.isEmpty(personParm.getFirstName())) {
				person.setFirstName(person.getFirstName());
			} else {
				person.setFirstName(personParm.getFirstName());
			}*/
			/*
			 * person.setFirstName(personParm.getFirstName());
			 * person.setLastName(personParm.getLastName());
			 * person.setCourse(personParm.getCourse());
			 * person.setFee(personParm.getFee());
			 * person.setStartDate(personParm.getStartDate());
			 * person.setEndDate(personParm.getEndDate());
			 */
			session.update(person);
			transaction.commit();
			return Constant.SUCCESS;

		} catch (HibernateException e) {
			// rollback if exception
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
			return Constant.UNSUCCESS;
		} finally {
			// close it
			session.close();
			sessionFactory.close();
		}
	}

	@Override
	public int deletePerson(int id) {
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			// load class
			Student person = (Student) session.get(Student.class, id);
			session.delete(person);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
			return Constant.UNSUCCESS;
		} finally {
			// close it
			session.close();
			sessionFactory.close();
		}
		return Constant.SUCCESS;
	}

}

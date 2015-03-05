package com.hibernate.wonderland.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.wonderland.common.Constant;
import com.hibernate.wonderland.persistent.Student;
import com.hibernate.wonderland.utilities.HibernateUtil;

/**
 * Implementor of StudentDAO which provided CRUD rules.
 * 
 * @author Alice
 */
public class StudentImpl implements StudentDAO {
	private SessionFactory sessionFactory = null;
	private Session session = null;
	private Transaction transaction = null;

	/**
	 * Default no-argument constructor
	 */

	public StudentImpl() {
	}

	@Override
	public int insertStudent(Student student) {
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			// To use annotation
			// HibernateUtil.getSessionFactoryAnno();
			session = sessionFactory.openSession();
			// save to database
			session.save(student);
			transaction = session.beginTransaction();
			// commit it
			transaction.commit();
			return Constant.SUCCESS;
		} catch (HibernateException e) {
			// if fail to insert data, roll back to success checkpoint
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
	public Student getStudentByID(int id) {
		Student student = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
		    student = (Student) session.get(Student.class, id);
			return student;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			// close it
			session.close();
			sessionFactory.close();
		}
		
	}

	@Override
	public List<Student> retrieveStudentCollection() {
		List<Student> studentList = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			studentList = (List<Student>) session.createCriteria(Student.class)
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			// close it
			session.close();
			sessionFactory.close();
		}
		return studentList;
	}

	/**
	 * This method query data by HQL approach
	 */
	@Override
	public List<Student> retrieveStudentByCourse(String course) {
		// set parameter for courseName
		List<Student> studentList = null;
		try {
			// create query, table name must be match with mapping file
			String sql = "from Student s where s.course = :courseName";
			// crate session
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			studentList = session.createQuery(sql)
					.setParameter("courseName", course).list();
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			// close it
			session.close();
			sessionFactory.close();
		}

		return studentList;

	}

	@Override
	public int updateStudent(Student studentparam) {
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			// make transaction
			transaction = session.beginTransaction();
			// load class
			//Student student = (Student) session.get(Student.class, id);
			// update new data
			session.update(studentparam);
			// commit it
			transaction.commit();
			return Constant.SUCCESS;

		} catch (HibernateException e) {
			// roll back if exception occur
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
	public int deleteStudent(int id) {
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			// load class
			Student student = (Student) session.get(Student.class, id);
			// delete it
			session.delete(student);
			// commit it
			transaction.commit();
			return Constant.SUCCESS;
		} catch (HibernateException e) {
			// if fail to delete data, roll back to success checkpoint
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

}

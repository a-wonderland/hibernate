package com.hibernate.wonderland.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.classic.Session;
import org.junit.Before;
import org.junit.Test;

import com.hibernate.wonderland.dao.PersonDAO;
import com.hibernate.wonderland.dao.PersonImpl;
import com.hibernate.wonderland.persistent.Student;

public class HibernateTest {

	SessionFactory sessionFactory;
	Session session;

	@Before
	public void setUp() throws Exception {
		Configuration config = new Configuration();
		config.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
		config.setProperty(Environment.URL,
				"jdbc:mysql://localhost:3306/wonderland");
		config.setProperty(Environment.USER, "root");
		config.setProperty(Environment.PASS, "root");
		config.setProperty(Environment.DIALECT,
				"org.hibernate.dialect.MySQLDialect");
		config.setProperty(Environment.SHOW_SQL, "true");
		config.setProperty(Environment.HBM2DDL_AUTO, "create-drop");
		// mapping class
		config.addResource("com/hibernate/wonderland/config/student.hbm.xml");
		// config.addClass(Student.class);
		// create session
		sessionFactory = config.buildSessionFactory();
		session = sessionFactory.openSession();

	}

	@Test
	public void testInsert() {
		// format date
		SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/M/yyyy");
		Date start = null, end = null;
		try {
			start = simpleFormat.parse("14/02/2015");
			end = simpleFormat.parse("11/11/2015");
		} catch (ParseException e) {

			e.printStackTrace();
		}

		Student std = new Student("Alice", "Wonderland", "Junit", 2000, start,
				end);
		PersonDAO stdDAO = new PersonImpl();

		int result;
		// insert
		result = stdDAO.insertPerson(std);

		assertNotNull(result);
		if (result < 1) {
			fail();
		}

		// assertEquals("Alice", std.getFirstName());
	}

	@Test
	public void testRetrieve() {
		// format date
		SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/M/yyyy");
		Date start = null, end = null;
		try {
			start = simpleFormat.parse("14/02/2015");
			end = simpleFormat.parse("11/11/2015");
		} catch (ParseException e) {

			e.printStackTrace();
		}

		Student std = new Student("Alice", "Wonderland", "Junit", 2000, start,
				end);
		PersonDAO stdDAO = new PersonImpl();

		int result;
		// insert
		result = stdDAO.insertPerson(std);

		assertNotNull(result);
		if (result < 1) {
			fail();
		}

		// assertEquals("Alice", std.getFirstName());
	}
}

package com.hibernate.wonderland.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.ResourceBundle;

import com.hibernate.wonderland.common.Constant;
import com.hibernate.wonderland.common.HelperFunction;
import com.hibernate.wonderland.dao.PersonDAO;
import com.hibernate.wonderland.dao.PersonImpl;
import com.hibernate.wonderland.persistent.Person;
import com.hibernate.wonderland.persistent.Student;

public class App {

	// default constructor
	private App() {
	}

	public static void main(String[] args) throws Exception {
		// load message resource
		ResourceBundle message = HelperFunction.loadResource();

		// format date
		SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/M/yyyy");
		Date start = null;
		Date end = null;
		// create instance
		Student std = null;

		try {
			// convert string to date
			start = simpleFormat.parse("14/02/2015");
			end = simpleFormat.parse("11/11/2015");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		// compare date
		if (start.compareTo(end) < 0) {
			// create instance
			std = new Student("Alice", "Wonderland", "Java", 2000, start, end);
		} else {
			System.out.println(message.getString(Constant.INCORRECT_DATE));
			throw new Exception();

		}

		PersonDAO personDAO = new PersonImpl();
		
		//******* Insert ************
		/*
		 * int result = personDAO.insertPerson(std);
		 * 
		 * if (result == 1) {
		 * System.out.println(message.getString(Constant.SAVE)); }
		 */

		//******* Retrieve ************
		 System.out.println(personDAO.retrievePersonByID(9));
		// retrieve collection type cast to child class
		List<Student> list = (List<Student>) (List<?>) personDAO
				.retrievePersonCollection();
		System.out.println("[Info] retrievePersonCollection");
		for (Student st : list) {

			System.out.println(std);
		}

		// retrieve collection by course name then type cast to child class
		List<Student> courseStd = (List<Student>) (List<?>) personDAO
				.retrievePersonByCourse("JavaScript");
		System.out.println("[Info] retrievePersonByCourse");
		for (Student st : courseStd) {

			System.out.println(st.getFirstName());
		}
		
		//******* Update ************
		Student stdUp = new Student();
		stdUp.setFirstName("Alice Update");
		//stdUp.setCourse("Hibernate");
		personDAO.updatePerson(9, stdUp);
		System.out.println(message.getString(Constant.UPDATE));
		
		//******* Delete ************
		personDAO.deletePerson(4);
		System.out.println(message.getString(Constant.DELETE));
	}

	// to do user input

}

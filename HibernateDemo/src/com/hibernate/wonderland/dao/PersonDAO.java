package com.hibernate.wonderland.dao;

import java.util.List;

import com.hibernate.wonderland.persistent.Person;
import com.hibernate.wonderland.persistent.Student;

public interface PersonDAO {

	// create
	public int insertPerson(Person person);

	// retrieve
	public Person retrievePersonByID(int id);

	public List<Person> retrievePersonCollection();

	public List<Person> retrievePersonByCourse(String course);

	// update
	//public int updatePersonByC(Person person);
	public int updatePerson(int id, Student person);

	// delete
	public int deletePerson(int id);
}

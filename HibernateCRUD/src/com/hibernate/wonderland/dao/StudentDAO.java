package com.hibernate.wonderland.dao;

import java.util.List;

import com.hibernate.wonderland.persistent.Student;

/**
 * This interface provided CRUD rules.
 * Implementor must be apply all rules.
 * 
 * @author Alice
 */

public interface StudentDAO {

	/**
	 * Save Student object to database
	 * 
	 * @param student Student type
	 * @return inserting status whether success or not
	 */
	public abstract int insertStudent(Student student);

	/**
	 * Retrieve specific Student data according to unique id
	 * 
	 * @param id primary key of Student table
	 * @return all columns of specific student data
	 */
	public Student getStudentByID(int id);

	/**
	 * Retrieve list of Students data
	 * 
	 * @return all Student records
	 */

	public List<Student> retrieveStudentCollection();

	/**
	 * Retrieve specific list Student data according to course name
	 * 
	 * @param course
	 * @return all columns of specific student data joining same course
	 */
	public List<Student> retrieveStudentByCourse(String course);

	/**
	 * Update specific Student data according to unique id
	 * 
	 * @param id primary key of Student table
	 * @return updating status whether success or not
	 */
	public int updateStudent(Student student);

	/**
	 * Delete specific Student according to unique id
	 * 
	 * @param id primary key of Student table
	 * @return deleting status whether success or not
	 */
	public int deleteStudent(int id);

}

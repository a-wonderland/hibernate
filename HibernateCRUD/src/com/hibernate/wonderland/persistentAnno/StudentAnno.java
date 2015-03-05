package com.hibernate.wonderland.persistentAnno;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

import org.hibernate.annotations.Generated;

import com.hibernate.wonderland.persistent.Student;

/**
 * Hibernate annotation class.
 * 
 * @author Alice
 */

@Entity
@Table (name="student")
public class StudentAnno extends Student{

	/**
	 * Explicitly declare a serialVersionUID
	 */
	private static final long serialVersionUID = -6659100867121902258L;

	/**
	 * Default constructor
	 */

	public StudentAnno() {
	}

	private int id;
	private String firstName;
	private String lastName;
	private String course;
	private float fee;
	private Date startDate;
	private Date endDate;


	/**
	 * Student class explicit constructor
	 */
	
	public StudentAnno(String firstName, String lastName, String course,
			float fee, Date startDate, Date endDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.course = course;
		this.fee = fee;
		this.startDate = startDate;
		this.endDate = endDate;
	}
// if @GeneratedValue is used AUTO_INCREMENT or setId need to provide
	@Id
	@Column (name = "studentID")
	@GeneratedValue
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	@Column (name = "firstName")
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column (name = "lastName")
	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column (name = "course")
	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}

	@Column (name = "fee")
	public float getFee() {
		return fee;
	}


	public void setFee(float fee) {
		this.fee = fee;
	}

	@Column (name = "startDate")
	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column (name = "endDate")
	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	@Override
	public String toString() {
		return "StudentAnno [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", course=" + course + ", fee="
				+ fee + ", startDate=" + startDate + ", endDate=" + endDate
				+ "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentAnno other = (StudentAnno) obj;
		if (id != other.id)
			return false;
		return true;
	}



}

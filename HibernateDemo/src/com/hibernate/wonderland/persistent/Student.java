/**
 * 
 */
package com.hibernate.wonderland.persistent;

import java.util.Date;

/**
 * @author Wonderland
 *
 */
public class Student extends Person{

	/**
	 * generated serialVersionUID
	 */
	private static final long serialVersionUID = -6995531679548663019L;

	private String course;
	private float fee;
	private Date startDate;
	private Date endDate;
	
	// default constructor
	public Student() {
		super();
	}


	public Student(String firstName, String lastName, String course, float fee, Date startDate, Date endDate) {
		// super constructor
		super(firstName, lastName);
		this.course = course;
		this.fee = fee;
		// defensive copy
		this.startDate = new Date(startDate.getTime());
		this.endDate = new Date(endDate.getTime());
	}


	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public float getFee() {
		return fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}

	public Date getStartDate() {
		return new Date(startDate.getTime());
	}

	public void setStartDate(Date startDate) {
		this.startDate = new Date(startDate.getTime());
	}

	public Date getEndDate() {
		// return (Date) endDate.clone();
		return new Date(endDate.getTime());
	}

	public void setEndDate(Date endDate) {
		this.endDate = new Date(endDate.getTime());
	}

	// override hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + Float.floatToIntBits(fee);
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}

	// override equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (Float.floatToIntBits(fee) != Float.floatToIntBits(other.fee))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [course=" + course + ", fee=" + fee + ", startDate="
				+ startDate + ", endDate=" + endDate + ", getId()=" + getId()
				+ ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + "]";
	}

}

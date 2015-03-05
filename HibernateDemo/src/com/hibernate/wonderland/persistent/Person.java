package com.hibernate.wonderland.persistent;

import java.io.Serializable;

public abstract class Person implements Serializable {
	/**
	 * generated serialVersionUID
	 */
	private static final long serialVersionUID = 931525495394095481L;
	private int id;
	private String firstName;
	private String lastName;

	// default constructor
	public Person() {
		super();
	}

	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// getter and setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}

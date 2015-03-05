package com.hibernate.wonderland.common;

public class Constant {

	// non-instantiated constructor
	private Constant() {

	}

	// database status
	public static final int SUCCESS = 1;
	public static final int UNSUCCESS = 0;
	
	// database messages properties
	public static final String SAVE = "message.save";
	public static final String UPDATE = "message.update";
	public static final String DELETE = "message.delete";
	public static final String FAIL = "message.fail";
	
	// user input messages properties
	public static final String INFO = "message.info";
	public static final String FIRST_NAME = "message.firstName";
	public static final String LAST_NAME = "message.lastName";
	public static final String COURSE = "message.course";
	public static final String FEE = "message.fee";
	public static final String START_DATE = "message.startDate";
	public static final String END_DATE = "message.endDate";
	public static final String INCORRECT_DATE = "message.incorrectFormat";

}

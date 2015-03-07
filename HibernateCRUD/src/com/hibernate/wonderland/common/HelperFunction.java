package com.hibernate.wonderland.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * This class is group of common functions.
 * Provided non-instantiated constructor.
 * 
 * @author Alice
 */
public class HelperFunction {

	/**
	 * Non-instantiated constructor
	 */
	private HelperFunction() {
	}

	/**
	 * This static method is supported for checking value of Object
	 * @param obj to compare
	 * @return true if the obj is empty or null 
	 */
	
	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		} else if (obj instanceof String) {
			if (((String) obj).length() < 0) {
				return true;
			}
		} else {
			return false;
		}
		return false;

	}

	/**
	 * This static method is supported for loading properties file.
	 * @param resourceName name of properties file
	 * @return Loaded ResourceBundle object that contain locale-specific messages. 
	 */
	
	public static ResourceBundle loadResource(String resourceName) {
		ResourceBundle bundle = null;
		try {
			bundle = ResourceBundle.getBundle(resourceName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bundle;
	}
	/**
	 * This static factory method provided for compare your input format and supported format
	 * @param testDate user input Date
	 * @param format e.g dd/M/yyyy
	 * @exception ParseException
	 * @return boolean true is date is match with format
	 */
	public static boolean isDateValid(String testDate, String format) {

		Date date = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		// make date validation more strictly
		simpleDateFormat.setLenient(false);

		if ("".equals(testDate) || testDate == null) {
			return false;
		}

		try {
			// valid
			date = simpleDateFormat.parse(testDate);
			System.out.println(date);

		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}
}

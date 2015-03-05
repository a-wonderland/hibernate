package com.hibernate.wonderland.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import com.hibernate.wonderland.common.Constant;
import com.hibernate.wonderland.common.HelperFunction;
import com.hibernate.wonderland.dao.StudentDAO;
import com.hibernate.wonderland.dao.StudentImpl;
import com.hibernate.wonderland.persistent.Student;
import com.hibernate.wonderland.persistentAnno.StudentAnno;
import com.sun.xml.internal.ws.org.objectweb.asm.Label;

/**
 * Main application to test CRUD.
 * 
 * @author Alice
 */

public class App {

	private static ResourceBundle message;
	private static BufferedReader reader;

	/**
	 * Default no-argument constructor
	 */
	public App() {
	}

	public static void main(String[] args) throws Exception {

		String select = null;

		// load message resource
		message = HelperFunction.loadResource(Constant.MESSAGESOURCE);

		// read input from console
		InputStreamReader inputStream = new InputStreamReader(System.in);
		reader = new BufferedReader(inputStream);

		System.out.println(message.getString(Constant.INFO));
		select = reader.readLine();

		try {
			if ((select).equals("1")) {

				userInput("INSERT");

			} else if ((select).equals("2")) {
				userInput("RETRIEVE");

			} else if ((select).equals("3")) {
				userInput("UPDATE");

			} else if ((select).equals("4")) {
				userInput("DELETE");

			} else if ((select).equals("5")) {
				System.exit(0);

			} else {
				System.exit(0);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void userInput(String choice) {
		int id;
		String firstName;
		String lastName;
		String course;
		String fee;
		String usrStartDate = null;
		String usrEndDate = null;

		StudentDAO stdDAO = new StudentImpl();

		// format date
		SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/M/yyyy");
		Date startDate = null;
		Date endDate = null;

		if ((choice).toUpperCase().equals("INSERT")) {

			try {
				System.out.println(message.getString(Constant.FIRST_NAME));
				firstName = reader.readLine();

				System.out.println(message.getString(Constant.LAST_NAME));
				lastName = reader.readLine();

				System.out.println(message.getString(Constant.COURSE));
				course = reader.readLine();

				System.out.println(message.getString(Constant.FEE));
				fee = reader.readLine();

				System.out.println(message.getString(Constant.START_DATE));
				usrStartDate = reader.readLine();

				System.out.println(message.getString(Constant.END_DATE));
				usrEndDate = reader.readLine();

				// convert string to date
				startDate = simpleFormat.parse(usrStartDate);
				endDate = simpleFormat.parse(usrEndDate);

				// check valid or not
				boolean valid = validateDate(startDate, endDate);

				if (valid) {

					Student std = new Student(firstName, lastName, course, Float.parseFloat(fee),
							startDate, endDate);
					int restult = stdDAO.insertStudent(std);
					if (restult == 1) {
						System.out.println(message.getString(Constant.SAVE));
					} else {
						System.out.println(message.getString(Constant.FAIL));
					}

					/*
					 * // hibernate annotation
					 * 
					 * StudentAnno stdAno = new StudentAnno(firstName, lastName,
					 * course, fee, startDate, endDate);
					 * stdDAO.insertStudent(stdAno);
					 */
				}

			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}

		} else if ((choice).toUpperCase().equals("RETRIEVE")) {

			try {
				System.out.println(message.getString(Constant.COURSE));
				course = reader.readLine();
				for (Student iter : stdDAO.retrieveStudentByCourse(course)) {
					System.out.println(iter);
				}
				/*System.out.println(message.getString(Constant.STUDENT_ID));
				id = Integer.parseInt(reader.readLine());
				System.out.println(stdDAO.getStudentByID(id));*/
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else if ((choice).toUpperCase().equals("UPDATE")) {

			try {
				Student student = new Student();

				System.out.println(message.getString(Constant.STUDENT_ID));
				id = Integer.parseInt(reader.readLine());
				if (!HelperFunction.isEmpty(id)) {
					student.setId(id);
				}

				System.out.println(message.getString(Constant.FIRST_NAME));
				firstName = reader.readLine();
				if (!HelperFunction.isEmpty(firstName)) {
					student.setFirstName(firstName);
				}

				System.out.println(message.getString(Constant.LAST_NAME));
				lastName = reader.readLine();
				if (!HelperFunction.isEmpty(lastName)) {
					student.setLastName(lastName);
				}

				System.out.println(message.getString(Constant.COURSE));
				course = reader.readLine();
				if (!HelperFunction.isEmpty(course)) {
					student.setCourse(course);
				}

				System.out.println(message.getString(Constant.FEE));
				fee = reader.readLine();
				if (!HelperFunction.isEmpty(fee)) {
					student.setFee(Float.parseFloat(fee));
				}

				System.out.println(message.getString(Constant.START_DATE));
				usrStartDate = reader.readLine();
				if (!HelperFunction.isEmpty(usrStartDate)) {
					student.setStartDate(simpleFormat.parse(usrStartDate));

				}

				System.out.println(message.getString(Constant.END_DATE));
				usrEndDate = reader.readLine();
				if (!HelperFunction.isEmpty(usrEndDate)) {
					student.setEndDate(simpleFormat.parse(usrEndDate));

				}

				int result = stdDAO.updateStudent(student);

				if (result == 1) {
					System.out.println(message.getString(Constant.UPDATE));
				} else {
					System.out.println(message.getString(Constant.FAIL));
				}

			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if ((choice).toUpperCase().equals("DELETE")) {

			try {
				System.out.println(message.getString(Constant.STUDENT_ID));
				id = Integer.parseInt(reader.readLine());
				int result = stdDAO.deleteStudent(id);
				if (result == 1) {
					System.out.println(message.getString(Constant.DELETE));
				} else {
					System.out.println(message.getString(Constant.FAIL));
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	private static boolean validateDate(Date usrStartDate, Date usrEndDate) {

		if (!(HelperFunction.isEmpty(usrStartDate) && HelperFunction
				.isEmpty(usrEndDate))) {

			// get today date
			Calendar cal = Calendar.getInstance();
			Date today = cal.getTime();

			if (usrStartDate.compareTo(today) > 0) {
				// compare date
				if (usrEndDate.compareTo(usrStartDate) < 0) {
					System.out.println(message
							.getString(Constant.INCORRECT_DATE));
					return false;

				} else {
					return true;
				}

			} else {
				throw new IllegalArgumentException(
						"Start Date Must Be After Today Date");
			}
		}

		return false;

	}

}

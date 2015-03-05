package com.hibernate.wonderland.common;

import java.util.ResourceBundle;

public class HelperFunction {

	private HelperFunction() {
		// TODO Auto-generated constructor stub
	}

	public static ResourceBundle loadResource() {
		ResourceBundle bundle = null;
		try {
			bundle = ResourceBundle.getBundle(ResourceMessages.MESSAGESOURCE
					.getResourceName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bundle;
	}

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

}

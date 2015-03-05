package com.hibernate.wonderland.common;

public enum ResourceMessages {
	//encapsulate 
	MESSAGESOURCE("MessagesBundle");

	private String resourceName;

	// provide only getter for immutable
	public String getResourceName() {
		return resourceName;
	}

	ResourceMessages(String resourceName) {
		this.resourceName = resourceName;
	}

	@Override
	public String toString() {
		return resourceName;
	}
}

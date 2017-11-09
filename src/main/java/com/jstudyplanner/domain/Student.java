package com.jstudyplanner.domain;


/**
 * Domain class that represents student user account.
 * @author oleg, oleglukin@yahoo.com
 */
public class Student extends User {
	private static final long serialVersionUID = 1L;
	
	// ----------------------------------------
	// Attributes
	// ----------------------------------------
	private String type; // domestic, international
	private Major major;
	private Campus campus;
	
	
	// ----------------------------------------
	// Constructors
	// ----------------------------------------
	public Student() {}

	public Student(Long id, String utype, String email, String username, String password, Byte enabled,
			String firstName, String lastName, String phone,
			String type, Major major, Campus campus) {
		super(id, utype, email, username, password, enabled, firstName, lastName, phone);
		this.type = type;
		this.major = major;
		this.campus = campus;
	}
	
	
	// ----------------------------------------
	// Getters & Setters
	// ----------------------------------------
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public Campus getCampus() {
		return campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}
}
package com.jstudyplanner.domain;

import java.io.Serializable;


/**
 * Domain class that represents the User account. This class should be extended
 * by various types of users (e.g. admin, staff, student).
 * @author oleg, oleglukin@yahoo.com
 */
public abstract class User implements Serializable, DomainObject {
	private static final long serialVersionUID = 1L;
	
	// ----------------------------------------
	// Attributes
	// ----------------------------------------
	private Long id;
	private String utype; // admin, staff, student
	private String email;
	private String username;
	private String password;
	private Byte enabled;
	private String firstName;
	private String lastName;
	private String phone;
	
	
	// ----------------------------------------
	// Constructors
	// ----------------------------------------
	public User() {}

	public User(Long id, String utype, String email, String username, String password, Byte enabled,
			String firstName, String lastName, String phone) {
		super();
		this.id = id;
		this.utype = utype;
		this.email = email;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
	}

	
	// ----------------------------------------
	// Getters & Setters
	// ----------------------------------------
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUtype() {
		return utype;
	}

	public void setUtype(String utype) {
		this.utype = utype;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Byte getEnabled() {
		return enabled;
	}

	public void setEnabled(Byte enabled) {
		this.enabled = enabled;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	/**
	 * Returns user's full name
	 * @return first name + last name
	 */
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	
	
	/**
	 * Compares two user accounts. Users are considered equal if they have the
	 * same username (not case sensitive). Other properties are not compared.
	 * @param domainObject - user to compare
	 * @return true if equal, false if not
	 */
	public boolean equals(DomainObject domainObject) {
		User user = (User) domainObject;
		if (user.getUsername().equalsIgnoreCase(this.getUsername())) {
			return true;
		} else {
			return false;
		}
	}
}
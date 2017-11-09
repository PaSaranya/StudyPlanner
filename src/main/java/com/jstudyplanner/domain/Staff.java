package com.jstudyplanner.domain;

import java.util.Set;


/**
 * Domain class that represents staff user account.
 * Properties of class include:
 * list of campuses that staff can manage.
 * @author oleg, oleglukin@yahoo.com
 */
public class Staff extends User {
	private static final long serialVersionUID = 1L;
	
	// ----------------------------------------
	// Attributes
	// ----------------------------------------
	private Set<Campus> managedCampuses; // list of campuses that staff user can manage
	
	
	// ----------------------------------------
	// Constructors
	// ----------------------------------------
	public Staff() {}

	public Staff(Long id, String utype, String email, String username, String password, Byte enabled,
			String firstName, String lastName, String phone, Set<Campus> managedCampuses) {
		super(id, utype, email, username, password, enabled, firstName, lastName, phone);
		this.managedCampuses = managedCampuses;
	}
	
	
	// ----------------------------------------
	// Getters & Setters
	// ----------------------------------------
	public Set<Campus> getManagedCampuses() {
		return managedCampuses;
	}

	public void setManagedCampuses(Set<Campus> managedCampuses) {
		this.managedCampuses = managedCampuses;
	}
}
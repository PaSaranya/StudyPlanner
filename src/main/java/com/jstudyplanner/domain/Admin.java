package com.jstudyplanner.domain;


/**
 * Domain class that represents admin user account.
 * It doesn't introduce any new properties or methods.
 * @author oleg, oleglukin@yahoo.com
 */
public class Admin extends User {
	private static final long serialVersionUID = 1L;

	// ----------------------------------------
	// Constructors
	// ----------------------------------------
	public Admin() {
		super();
	}
	
	public Admin(Long id, String utype, String email, String username, String password, Byte enabled,
			String firstName, String lastName, String phone) {
		super(id, utype, email, username, password, enabled, firstName, lastName, phone);
	}
}
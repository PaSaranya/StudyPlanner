package com.jstudyplanner.domain;

import java.io.Serializable;


/**
 * Domain class that represents the Campus entity.
 * @author oleg, oleglukin@yahoo.com
 */
public class Campus implements Serializable, DomainObject {
	private static final long serialVersionUID = 1L;
	
	// ----------------------------------------
	// Attributes
	// ----------------------------------------
	private Long id;
	private String code;
	private String title;
	private Byte enabled;
	private String address;
	private String phone;
	private String description;
	
	
	// ----------------------------------------
	// Constructors
	// ----------------------------------------
	public Campus() {}

	public Campus(Long id, String code, String title, Byte enabled, 
			String address,	String phone, String description) {
		super();
		this.id = id;
		this.code = code;
		this.title = title;
		this.enabled = enabled;
		this.address = address;
		this.phone = phone;
		this.description = description;
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
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Byte getEnabled() {
		return enabled;
	}

	public void setEnabled(Byte enabled) {
		this.enabled = enabled;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	/**
	 * Return description preview getting first n characters.
	 * @param numberOfCharacters to display
	 * @return description preview
	 */
	public String getDescriptionPreview(int numberOfCharacters) {
		if (description.length() > numberOfCharacters) {
			return description.substring(0, numberOfCharacters);
		} else {
			return description;
		}
	}

	/**
	 * Compares two campuses. Campuses are considered equal if they have the same
	 * code, and title. Id, description, phone and address are not compared.
	 * @param domainObject - campus to compare
	 * @return true if equal, false if not
	 */
	public boolean equals(DomainObject domainObject) {
		Campus campus = (Campus) domainObject;
		if (campus.getCode().equals(this.getCode())
			&& campus.getTitle().equals(this.getTitle())
			) {
			return true;
		} else {
			return false;
		}
	}
}
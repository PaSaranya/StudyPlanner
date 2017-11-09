package com.jstudyplanner.domain;

import java.io.Serializable;
import java.util.Set;


/**
 * Domain class that represents the Major entity.
 * @author oleg, oleglukin@yahoo.com
 */
public class Major implements Serializable, DomainObject {
	private static final long serialVersionUID = 1L;
	
	// ----------------------------------------
	// Attributes
	// ----------------------------------------
	private Long id;
	private String code;
	private String title;
	private Byte enabled;
	private String description;
	private Program program;
	
	private Set<Course> compulsoryCourses;
	

	// ----------------------------------------
	// Constructors
	// ----------------------------------------
	public Major() {}

	public Major(Long id, String code, String title, Byte enabled, String description, Program program, Set<Course> compulsoryCourses) {
		super();
		this.id = id;
		this.code = code;
		this.title = title;
		this.enabled = enabled;
		this.description = description;
		this.program = program;
		this.compulsoryCourses = compulsoryCourses;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public Set<Course> getCompulsoryCourses() {
		return compulsoryCourses;
	}

	public void setCompulsoryCourses(Set<Course> compulsoryCourses) {
		this.compulsoryCourses = compulsoryCourses;
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
	 * Compares two majors. Majors are considered equal if they have the same
	 * code, and title. Id, description, program and compulsory courses are not compared.
	 * @param domainObject - major to compare
	 * @return true if equal, false if not
	 */
	public boolean equals(DomainObject domainObject) {
		Major major = (Major) domainObject;
		if (major.getCode().equals(this.getCode())
			&& major.getTitle().equals(this.getTitle())
			) {
			return true;
		} else {
			return false;
		}
	}
}
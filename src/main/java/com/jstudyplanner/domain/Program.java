package com.jstudyplanner.domain;

import java.io.Serializable;
import java.util.Set;


/**
 * Domain class that represents the Program entity.
 * @author oleg, oleglukin@yahoo.com
 */
public class Program implements Serializable, DomainObject {
	private static final long serialVersionUID = 1L;
	
	// ----------------------------------------
	// Attributes
	// ----------------------------------------
	private Long id;
	private String code;
	private String title;
	private Byte enabled;
	private String description;
	private String career; // undergraduate, postgraduate
	private Integer numberOfCourses;
	
	private Set<Course> coreCourses;
	private Set<Course> electiveCourses;
	
	
	// ----------------------------------------
	// Constructors
	// ----------------------------------------
	public Program() {}

	public Program(Long id, String code, String title, Byte enabled, String description, String career, 
			Integer numberOfCourses, Set<Course> coreCourses, Set<Course> electiveCourses) {
		super();
		this.id = id;
		this.code = code;
		this.title = title;
		this.enabled = enabled;
		this.description = description;
		this.career = career;
		this.numberOfCourses = numberOfCourses;
		this.coreCourses = coreCourses;
		this.electiveCourses = electiveCourses;
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

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}
	
	public Integer getNumberOfCourses() {
		return numberOfCourses;
	}

	public void setNumberOfCourses(Integer numberOfCourses) {
		this.numberOfCourses = numberOfCourses;
	}

	public Set<Course> getCoreCourses() {
		return coreCourses;
	}

	public void setCoreCourses(Set<Course> coreCourses) {
		this.coreCourses = coreCourses;
	}

	public Set<Course> getElectiveCourses() {
		return electiveCourses;
	}

	public void setElectiveCourses(Set<Course> electiveCourses) {
		this.electiveCourses = electiveCourses;
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
	 * Compares two programs. Programs are considered equal if they have the same
	 * code and title. It is not necessary for other parameters to be equal.
	 * @param domainObject - program to compare
	 * @return true if equal, false if not
	 */
	public boolean equals(DomainObject domainObject) {
		Program program = (Program) domainObject;
		if (program.getCode().equals(this.getCode())
			&& program.getTitle().equals(this.getTitle())
			) {
			return true;
		} else {
			return false;
		}
	}
}
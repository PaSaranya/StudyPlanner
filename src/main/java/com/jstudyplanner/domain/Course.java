package com.jstudyplanner.domain;

import java.io.Serializable;
import java.util.Set;


/**
 * Domain class that represents the Course entity.
 * @author oleg, oleglukin@yahoo.com
 */
public class Course implements Serializable, DomainObject {
	private static final long serialVersionUID = 1L;
	
	// ----------------------------------------
	// Attributes
	// ----------------------------------------
	private Long id;
	private String code;
	private String title;
	private Byte enabled;
	private String description;
	
	private Set<Course> prerequisites;
	
	
	// ----------------------------------------
	// Constructors
	// ----------------------------------------
	public Course() {}

	public Course(Long id, String code, String title, Byte enabled, String description, Set<Course> prerequisites) {
		super();
		this.id = id;
		this.code = code;
		this.title = title;
		this.enabled = enabled;
		this.description = description;
		this.prerequisites = prerequisites;
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

	public Set<Course> getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(Set<Course> prerequisites) {
		this.prerequisites = prerequisites;
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
	 * Compares two courses. Courses are considered equal if they have the same
	 * code, and title. Id, description and prerequisites are not compared.
	 * @param domainObject - course to compare
	 * @return true if equal, false if not
	 */
	public boolean equals(DomainObject domainObject) {
		Course course = (Course) domainObject;
		if (course.getCode().equals(this.getCode())
			&& course.getTitle().equals(this.getTitle())
			) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Overrides Object's equals method. Used in methods like List.contains()
	 * @param object - object (course) to compare
	 * @return true if equal, false if not
	 */
	public boolean equals(Object object) {
		if (object == this) {
			return true;
		}
		if (object == null) {
			return false;
		}
		if (object instanceof Course) {
			Course course = (Course) object;
			if (course.getCode().equals(this.getCode())
				&& course.getTitle().equals(this.getTitle())
				) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
}
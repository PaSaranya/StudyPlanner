package com.jstudyplanner.domain;

import java.io.Serializable;


/**
 * Course availability means that course A is available in campus B during term C.
 * @author oleg, oleglukin@yahoo.com
 */
public class CourseAvailability implements Serializable, DomainObject {
	private static final long serialVersionUID = 1L;
	
	// ----------------------------------------
	// Attributes
	// ----------------------------------------
	private Long id;
	private Term term;
	private Course course;
	private Campus campus;
	private Byte enabled;
	
	
	// ----------------------------------------
	// Constructors
	// ----------------------------------------
	public CourseAvailability() {}

	public CourseAvailability(Long id, Term term, Course course, Campus campus) {
		super();
		this.id = id;
		this.term = term;
		this.course = course;
		this.campus = campus;
	}
	
	public CourseAvailability(Long id, Term term, Course course, Campus campus, Byte enabled) {
		super();
		this.id = id;
		this.term = term;
		this.course = course;
		this.campus = campus;
		this.enabled = enabled;
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

	public Term getTerm() {
		return term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Campus getCampus() {
		return campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}
	
	public Byte getEnabled() {
		return enabled;
	}

	public void setEnabled(Byte enabled) {
		this.enabled = enabled;
	}
	

	/**
	 * Compare 2 CourseAvailability objects. To be equal
	 * their courses, terms and campuses should be equal.
	 * @param domainObject - ca(CourseAvailability) to compare
	 * @return true if equal, false if not
	 */
	public boolean equals(DomainObject domainObject) {
		CourseAvailability ca = (CourseAvailability) domainObject;
		if (ca.getTerm().compare(this.getTerm()) == 0
			&& ca.getCourse().equals(this.getCourse())
			&& ca.getCampus().equals(this.getCampus())
				) {
			return true;
		} else {
			return false;
		}
	}
}
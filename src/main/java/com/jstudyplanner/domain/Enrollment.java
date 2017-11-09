package com.jstudyplanner.domain;

import java.io.Serializable;


/**
 * Domain class that represents the Enrollment entity.
 * @author oleg, oleglukin@yahoo.com
 */
public class Enrollment implements Serializable, DomainObject {
	private static final long serialVersionUID = 1L;
	
	// ----------------------------------------
	// Attributes
	// ----------------------------------------
	private Long id;
	private CourseAvailability courseAvailability;
	private Student student;
	private String status; // planned, enrolled
	
	
	// ----------------------------------------
	// Constructors
	// ----------------------------------------
	public Enrollment() {}

	public Enrollment(Long id, CourseAvailability courseAvailability, Student student, String status) {
		super();
		this.id = id;
		this.courseAvailability = courseAvailability;
		this.student = student;
		this.status = status;
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public CourseAvailability getCourseAvailability() {
		return courseAvailability;
	}

	public void setCourseAvailability(CourseAvailability courseAvailability) {
		this.courseAvailability = courseAvailability;
	}

	
	/**
	 * Compares two enrollments. Enrollments considered equal if they have the same
	 * student and CourseAvailability.
	 * @param domainObject - enrollment to compare
	 * @return true if equal, false if not
	 */
	public boolean equals(DomainObject domainObject) {
		Enrollment enrollment = (Enrollment) domainObject;
		if (enrollment.getStudent().equals(this.getStudent())
			&& enrollment.getCourseAvailability().equals(this.getCourseAvailability())
			) {
			return true;
		} else {
			return false;
		}
	}
}
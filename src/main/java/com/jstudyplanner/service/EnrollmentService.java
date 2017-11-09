package com.jstudyplanner.service;

import java.util.List;

import com.jstudyplanner.domain.CourseAvailability;
import com.jstudyplanner.domain.Enrollment;
import com.jstudyplanner.domain.Student;
import com.jstudyplanner.domain.User;

/**
 * Defines business rules for Enrollments
 */
public interface EnrollmentService {
	public void save(Enrollment enrollment);
	
	/**
	 * Delete enrollment.
	 * @param enrollment
	 * @param user - determines whether user have rights to delete enrollment
	 */
	public void delete(Enrollment enrollment, User user);
	public Enrollment getEnrollmentById(Long id);
	public Enrollment getEnrollmentByCAAndStudent(CourseAvailability ca, Student student);
	public List<Enrollment> getAllEnrollments();
	public List<Enrollment> getEnrollmentsByStatus(String status);
	public List<Enrollment> getEnrollmentsByCA(CourseAvailability ca);
	public List<Enrollment> getEnrollmentsByStudent(Student student);
}
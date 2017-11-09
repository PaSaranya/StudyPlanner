package com.jstudyplanner.dao;


import java.util.List;

import com.jstudyplanner.domain.CourseAvailability;
import com.jstudyplanner.domain.Enrollment;
import com.jstudyplanner.domain.Student;

/**
 * Defines CRUD methods for Enrollment entities
 * @author oleg
 */
public interface EnrollmentDAO {
	public void add(Enrollment enrollment);
	public void save(Enrollment enrollment);
	public void delete(Enrollment enrollment);
	public void delete(Long id);
	public Enrollment getEnrollmentById(Long id);
	public Enrollment getEnrollmentByCAAndStudent(CourseAvailability ca, Student student);
	public List<Enrollment> getAllEnrollments();
	public List<Enrollment> getEnrollmentsByCA(CourseAvailability ca);
	public List<Enrollment> getEnrollmentsByStudent(Student student);
	public List<Enrollment> getEnrollmentsByStatus(String status);
	public int countAll();
}
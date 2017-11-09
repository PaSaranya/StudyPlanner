package com.jstudyplanner.service;

import java.util.List;

import com.jstudyplanner.domain.Course;

/**
 * Defines business rules for managing courses
 */
public interface CourseService {
	public void save(Course course);
	public void delete(Course course);
	public Course getCourseById(Long id);
	public Course getCourseByCode(String code);
	public List<Course> getAllCourses();
	public List<Course> getCoursesByStatus(boolean enabled);
	public List<Course> getAvailablePrerequisites(Long courseID);
	public void removePrerequisites(Long courseID, Long[] prerequisiteIDs);
	public void addPrerequisites(Long courseID, Long[] prerequisiteIDs);
}
package com.jstudyplanner.dao;

import java.util.List;

import com.jstudyplanner.domain.Course;

/**
 * Defines CRUD methods for Course entities
 * @author oleg
 */
public interface CourseDAO {
	public void add(Course course);
	public void save(Course course);
	public void delete(Course course);
	public void delete(Long id);
	public Course getCourseById(Long id);
	public Course getCourseByCode(String code);
	public Course getCourseByTitle(String title);
	public int countAll();
	public List<Course> getAllCourses();
	public List<Course> getCoursesByStatus(boolean enabled);
}
package com.jstudyplanner.dao;

import java.util.List;

import com.jstudyplanner.domain.Campus;
import com.jstudyplanner.domain.Course;
import com.jstudyplanner.domain.CourseAvailability;
import com.jstudyplanner.domain.Term;

/**
 * Defines CRUD methods for CourseAvailability entities
 * @author oleg
 */
public interface CourseAvailabilityDAO {
	public void add(CourseAvailability courseAvailability);
	public void save(CourseAvailability courseAvailability);
	public void delete(CourseAvailability courseAvailability);
	public void delete(Long id);
	public CourseAvailability getCAById(Long id);
	public CourseAvailability getCAByTermCourseCampus(Term term, Course course, Campus campus);
	public List<CourseAvailability> getAllCAs();
	public List<CourseAvailability> getCAsByStatus(boolean enabled);
	public List<CourseAvailability> getCAByTerm(Term term);
	public List<CourseAvailability> getCAByCourse(Course course);
	public List<CourseAvailability> getCAByCampus(Campus campus);
	public List<CourseAvailability> getCAByCampusAndTerm(Campus campus, Term term);
	public int countAll();
}
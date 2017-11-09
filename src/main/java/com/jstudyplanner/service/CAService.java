package com.jstudyplanner.service;

import java.util.List;

import com.jstudyplanner.domain.Campus;
import com.jstudyplanner.domain.Course;
import com.jstudyplanner.domain.CourseAvailability;
import com.jstudyplanner.domain.Term;

/**
 * Defines business rules for CourseAvailability objects (courses schedule)
 */
public interface CAService {
	public void save(CourseAvailability ca);
	public void delete(CourseAvailability ca);
	public CourseAvailability getCAById(Long id);
	public CourseAvailability getCAByCampusTermAndCourse(Campus campus, Term term, Course course);
	public List<CourseAvailability> getAllCAs();
	public List<CourseAvailability> getCAByStatus(boolean enabled);
	public List<CourseAvailability> getCAByCampus(Campus campus);
	public List<CourseAvailability> getCAByTerm(Term term);
	public List<CourseAvailability> getCAByCourse(Course course);
	public List<CourseAvailability> getCAByCampusAndTerm(Campus campus,	Term term);
	public List<Course> getAvailableCACourses(Long campusID, Long termID);
	public StringBuilder createMultipleCA(Campus campus, Term term, Long[] courseIDs);
}
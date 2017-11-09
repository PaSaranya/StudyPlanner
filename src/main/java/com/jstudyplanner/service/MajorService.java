package com.jstudyplanner.service;

import java.util.List;

import com.jstudyplanner.domain.Course;
import com.jstudyplanner.domain.Major;

/**
 * Defines business rules for managing majors
 * @author oleg
 */
public interface MajorService {
	public void save(Major major);
	public void delete(Major major);
	public Major getMajorById(Long id);
	public Major getMajorByCode(String code);
	public List<Major> getAllMajors();
	public void removeCompulsoryCourses(Long majorID, Long[] courseIDs);
	public void addCompulsoryCourses(Long majorID, Long[] courseIDs);
	public List<Course> getAvailableCompulsoryCourses(Long majorID);
}
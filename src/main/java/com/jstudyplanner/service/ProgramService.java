package com.jstudyplanner.service;

import java.util.List;

import com.jstudyplanner.domain.Course;
import com.jstudyplanner.domain.Major;
import com.jstudyplanner.domain.Program;

/**
 * Defines business rules for managing programs
 * @author oleg
 */
public interface ProgramService {
	public void save(Program program);
	public void deleteProgram(Program program);
	public Program getProgramById(Long id);
	public Program getProgramByCode(String code);
	public List<Program> getAllPrograms();
	public List<Program> getProgramsByStatus(boolean enabled);
	public List<Major> getProgramMajors(Program program);
	public List<Course> getAvailableCoreCourses(Long programID);
	public void removeCoreCourses(Long programID, Long[] courseIDs);
	public void addCoreCourses(Long programID, Long[] courseIDs);
	public List<Course> getAvailableElectiveCourses(Long programID);
	public void removeElectiveCourses(Long programID, Long[] courseIDs);
	public void addElectiveCourses(Long programID, Long[] courseIDs);
}
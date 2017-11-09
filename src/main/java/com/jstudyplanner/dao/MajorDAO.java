package com.jstudyplanner.dao;

import java.util.List;

import com.jstudyplanner.domain.Major;
import com.jstudyplanner.domain.Program;

/**
 * Defines CRUD methods for Major entities
 * @author oleg
 */
public interface MajorDAO {
	public void add(Major major);
	public void save(Major major);
	public void delete(Major major);
	public void delete(Long id);
	public Major getMajorById(Long id);
	public Major getMajorByCode(String code);
	public Major getMajorByTitleAndProgram(String title, Program program);
	public int countAll();
	public List<Major> getAllMajors();
}
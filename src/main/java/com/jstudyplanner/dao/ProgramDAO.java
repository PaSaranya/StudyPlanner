package com.jstudyplanner.dao;


import java.util.List;

import com.jstudyplanner.domain.Major;
import com.jstudyplanner.domain.Program;

/**
 * Defines CRUD methods for Program entities
 * @author oleg
 */
public interface ProgramDAO {
	public void add(Program program);
	public void save(Program program);
	public void delete(Program program);
	public void delete(Long id);
	public Program getProgramById(Long id);
	public Program getProgramByCode(String code);
	public Program getProgramByTitle(String title);
	public int countAll();
	public List<Program> getAllPrograms();
	public List<Program> getProgramsByCareer(String career);
	public List<Program> getProgramsByStatus(boolean enabled);
	public List<Major> getProgramMajors(Program program);
}

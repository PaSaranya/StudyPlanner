package com.jstudyplanner.dao;

import java.util.List;

import com.jstudyplanner.domain.Campus;

/**
 * Defines CRUD methods for Campus entities
 * @author oleg
 */
public interface CampusDAO {
	public void add(Campus campus);
	public void save(Campus campus);
	public void delete(Campus campus);
	public void delete(Long id); // Delete campus with given id
	public Campus getCampusById(Long id);
	public Campus getCampusByCode(String code);
	public Campus getCampusByTitle(String title);
	public int countAll();
	public List<Campus> getAllCampuses();
	public List<Campus> getCampusesByStatus(boolean enabled);
}
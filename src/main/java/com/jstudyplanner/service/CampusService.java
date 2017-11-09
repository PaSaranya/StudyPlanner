package com.jstudyplanner.service;

import java.util.List;

import com.jstudyplanner.domain.Campus;

/**
 * Defines business rules for managing campuses
 */
public interface CampusService {
	public void save(Campus campus);
	public void delete(Campus campus);
	public Campus getCampusById(Long id);
	public Campus getCampusByCode(String code);
	public List<Campus> getAllCampuses();
	public List<Campus> getCampusesByStatus(boolean enabled);
}
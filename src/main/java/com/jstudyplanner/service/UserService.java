package com.jstudyplanner.service;

import java.util.List;

import com.jstudyplanner.domain.Admin;
import com.jstudyplanner.domain.Staff;
import com.jstudyplanner.domain.Student;
import com.jstudyplanner.domain.User;
import com.jstudyplanner.service.implementation.CustomServiceException;

/**
 * Defines business methods for managing various types of users
 */
public interface UserService {
	public void save(User user) throws CustomServiceException;
	public void delete(User user);
	public void delete(String username);
	
	public User getUserById(Long id);
	public User getUserByUsername(String username);
	public User getUserByEmail(String email);
	
	public List<User>getAllUsers();
	public List<User>getUsersByLastName();
	public List<User>getUsersByFirstName();
	public List<User>getEnabledOrDisabledUsers(boolean enabled);
	
	public List<Admin>getAllAdmins();
	public List<Staff>getAllStaff();
	public List<Student>getAllStudents();
	
	// TODO add other staff and student methods
}
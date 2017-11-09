package com.jstudyplanner.dao;

import java.util.List;

import com.jstudyplanner.domain.User;

public interface UserDAO {
	public void add(User user);
	public void save(User user);
	public void delete(User user);
	public void delete(String username);
	public void delete(Long id); // Delete user with given id
	public User getUserById(Long id);
	public User getUserByUsername(String username);
	public User getUserByEmail(String email);
	public int countAll();
	public int countByUserType(String userType);
	public List<User> getAllUsers();
	public <T> List<T> getUsersByType(String userType);
}
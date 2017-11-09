package com.jstudyplanner.dao;

import java.util.List;

import com.jstudyplanner.domain.Term;

/**
 * Defines CRUD methods for Term entities
 * @author oleg
 */
public interface TermDAO {
	public void add(Term term);
	public void save(Term term);
	public void delete(Term term);
	public void delete(Long id);
	public Term getTermById(Long id);
	public Term getTermByYearAndNumber(Integer year, Integer number);
	public List<Term> getAllTerms();
	public List<Term> getTermsByStatus(boolean enabled);
	public int countAll();
}
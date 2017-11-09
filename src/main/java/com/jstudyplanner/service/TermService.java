package com.jstudyplanner.service;

import java.util.List;

import com.jstudyplanner.domain.Term;

/**
 * Defines business rules for managing terms
 */
public interface TermService {
	public void save(Term campus);
	public void delete(Term campus);
	public Term getTermById(Long id);
	public Term getTermByYearAndNumber(Integer year, Integer number);
	public List<Term> getAllTerms();
	public List<Term> getTermsByStatus(boolean enabled);
	public List<Term> getFutureTerms();
}
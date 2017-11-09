package com.jstudyplanner.domain;

import java.io.Serializable;
import java.sql.Date;


/**
 * Domain class that represents the Term entity.
 * @author oleg, oleglukin@yahoo.com
 */
public class Term implements Serializable, DomainObject {
	private static final long serialVersionUID = 1L;
	
	// ----------------------------------------
	// Attributes
	// ----------------------------------------
	private Long id;
	private Integer year;
	private Integer number;
	private Date startDate;
	private Date finishDate;
	private Byte enabled;
	
	
	// ----------------------------------------
	// Constructors
	// ----------------------------------------
	public Term() {}

	public Term(Long id, Integer year, Integer number, Date startDate, Date finishDate, Byte enabled) {
		super();
		this.id = id;
		this.year = year;
		this.number = number;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.enabled = enabled;
	}

	
	// ----------------------------------------
	// Getters & Setters
	// ----------------------------------------
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	
	public Byte getEnabled() {
		return enabled;
	}

	public void setEnabled(Byte enabled) {
		this.enabled = enabled;
	}
	
	
	/**
	 * Compares two terms chronologically. Returns an Integer
	 * indicating whether this term is greater (later) than (result is > 0),
	 * equal to (result is = 0), or less (earlier) than (result is < 0) the argument.
	 * Example: Term 1 2013 should be greater than Term 2 2012.
	 * @param term to compare
	 * @return -1, 0 or 1
	 */
	public Integer compare(Term term) {
		if (this.getYear() > term.getYear()) {
			return 1;
		} else if (this.getYear() < term.getYear()) {
			return -1;
		} else { // years are equal
			if (this.getNumber() > term.getNumber()) {
				return 1;
			} else if (this.getNumber() < term.getNumber()) {
				return -1;
			} else { // year and term number are both equal
				return 0;
			}
		}
	}

	/**
	 * Compares two terms. This method overrides DomainObject interface. 
	 * Terms are considered equal if they have the same
	 * year and number. Other properties are not compared.
	 * @param domainObject - term to compare
	 * @return true if equal, false if not
	 */
	public boolean equals(DomainObject domainObject) {
		Term term = (Term) domainObject;
		if (term.getYear() == this.getYear() && term.getNumber() == this.getNumber()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Should be used to display term like this: 'Term 1 2013'
	 */
	public String getShortDescription() {
		return "term " + this.number + " " + this.year;
	}
}
package com.jstudyplanner.domain;


/**
 * This interface should be used to mark all domain objects that have IDs.
 * It is then should be used in service objects' methods to compare domain objects.
 */
public interface DomainObject {
	public Long getId();
	public boolean equals(DomainObject domainObject);
}
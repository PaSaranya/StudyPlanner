package com.jstudyplanner.service.implementation;

import com.jstudyplanner.domain.DomainObject;

/**
 * Service class that allows other service objects to use its methods.
 * Accessible only from the com.jstudyplanner.service.implementation package.
 */
class GeneralService {
	
	/**
	 * This method is created to eliminate code repetition.
	 * It is used in various service objects to compare domain objects before updating or creating them.
	 * E.g. if you need to update student in the database you need to make sure that username is unique.
	 * Get a user with same username from DB and then compare them. If they are the same (not null and have same IDs)
	 * then update/create operation should be aborted.
	 */
	public static boolean domainObjectsAreSame(DomainObject domainObject, DomainObject domainObjectToCheck) {
		if (
				domainObjectToCheck != null // there is an existing object in the database
				&& (
					// 1. Create check (new domain object shouldn't have id)
					( domainObject.getId() == null ) 
					// 2. Update check
					|| (
							domainObject.getId() != null // this is update operation (not new object)
						// new object and existing are not the same one (have different IDs)
						&& !domainObject.getId().equals(domainObjectToCheck.getId())
					)
				)
			) {
			return true;
		} else {
			return false;
		}
	}
}

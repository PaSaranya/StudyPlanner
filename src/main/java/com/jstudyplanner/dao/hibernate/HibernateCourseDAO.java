package com.jstudyplanner.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jstudyplanner.dao.CourseDAO;
import com.jstudyplanner.domain.Course;

/**
 * Data Access Object that implements CourseDAO interface using Hibernate 
 * to persist/update/delete/get Course objects into the database.
 * 
 * All methods apart from setSessionFactory should be executed within
 * transaction. get* methods correspond to readOnly transactions.
 * @author oleg
 */
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class HibernateCourseDAO implements CourseDAO {
	
	// injection should be defined in the hibernate-context.xml
	private SessionFactory sessionFactory;
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional(readOnly=false)
	public void add(Course course) {
		if (course.getEnabled() == null) {
			course.setEnabled((byte) 0);
		}
		this.sessionFactory.getCurrentSession().persist(course);
	}

	@Transactional(readOnly=false)
	public void save(Course course) {
		if (course.getEnabled() == null) {
			course.setEnabled((byte) 0);
		}
		this.sessionFactory.getCurrentSession().update(course);
	}

	@Transactional(readOnly=false)
	public void delete(Course course) {
		this.sessionFactory.getCurrentSession().delete(course);
	}

	/**
	 * Attempts to delete course found by given id
	 */
	@Transactional(readOnly=false)
	public void delete(Long id) {
		Course course = (Course) this.sessionFactory.getCurrentSession().get(Course.class, id);
		if (course != null) {
			this.sessionFactory.getCurrentSession().delete(course);
		}
	}

	
	public Course getCourseById(Long id) {
		return (Course) this.sessionFactory.getCurrentSession().get(Course.class, id);
	}

	
	public Course getCourseByCode(String code) {
		String hql = "FROM Course c WHERE c.code = :code";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("code", code);
		List<Course> results = query.list();
		if (results.size() != 0) {
			return results.get(0);
		} else {
			return null;
		}
	}
	
	
	public Course getCourseByTitle(String title) {
		String hql = "FROM Course c WHERE c.title = :title";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("title", title);
		List<Course> results = query.list();
		if (results.size() != 0) {
			return results.get(0);
		} else {
			return null;
		}
	}

	
	public int countAll() {
		String hql = "SELECT COUNT(*) FROM Course";
		return ((Long)this.sessionFactory.getCurrentSession().createQuery(hql).uniqueResult()).intValue();
	}

	
	public List<Course> getAllCourses() {
		String hql = "FROM Course c ORDER BY c.title";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	
	/**
	 * Get list of courses by status: enabled (true) or disabled (false)
	 */
	public List<Course> getCoursesByStatus(boolean enabled) {
		// TODO add unit test for getAllCoursesByStatus
		String hql = "FROM Course c WHERE c.enabled = :enabledCode ORDER BY c.title";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		byte enabledCode = enabled? (byte)1 : (byte)0;
		query.setParameter("enabledCode", enabledCode);
		return query.list();
	}
}
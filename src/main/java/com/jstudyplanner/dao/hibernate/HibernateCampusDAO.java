package com.jstudyplanner.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jstudyplanner.dao.CampusDAO;
import com.jstudyplanner.domain.Campus;

/**
 * Data Access Object that implements CampusDAO interface using Hibernate 
 * to persist/update/delete/get Campus objects into the database.
 * 
 * All methods apart from setSessionFactory should be executed within
 * transaction. get* methods correspond to readOnly transactions.
 * @author oleg
 */
@Repository
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class HibernateCampusDAO implements CampusDAO {
	
	// injection should be defined in the hibernate-context.xml
	//private SessionFactory sessionFactory;

	@Autowired
	private SessionFactory sessionFactory;
    @PersistenceContext
    private EntityManager entityManager;
	  /*  @Autowired
	   public HibernateCampusDAO(SessionFactory sessionFactory) {
	        this.sessionFactory=sessionFactory;
	   }*/
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Transactional(readOnly=false)
	public void add(Campus campus) {
		if (campus.getEnabled() == null) {
			campus.setEnabled((byte) 0);
		}
		this.sessionFactory.getCurrentSession().persist(campus);
	}

	
	@Transactional(readOnly=false)
	public void save(Campus campus) {
		if (campus.getEnabled() == null) {
			campus.setEnabled((byte) 0);
		}
		this.sessionFactory.getCurrentSession().update(campus);
	}

	
	@Transactional(readOnly=false)
	public void delete(Campus campus) {
		this.sessionFactory.getCurrentSession().delete(campus);
	}
	
	
	/**
	 * Attempts to delete campus found by given id
	 */
	@Transactional(readOnly=false)
	public void delete(Long id) {
		Campus campus = getCampusById(id);
		if (campus != null) {
			this.sessionFactory.getCurrentSession().delete(campus);
		}
	}
	
	
	public Campus getCampusById(Long id) {
		return (Campus) this.sessionFactory.getCurrentSession().get(Campus.class, id);
	}
	
	
	public Campus getCampusByCode(String code) {
		String hql = "FROM Campus c WHERE c.code = :code";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("code", code);
		List<Campus> results = query.list();
		if (results.size() != 0) {
			return results.get(0);
		} else {
			return null;
		}
	}
	
	
	public Campus getCampusByTitle(String title) {
		String hql = "FROM Campus c WHERE c.title = :title";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("title", title);
		List<Campus> results = query.list();
		if (results.size() != 0) {
			return results.get(0);
		} else {
			return null;
		}
	}
	
	
	public int countAll() {
		String hql = "SELECT COUNT(*) FROM Campus";
		return ((Long)this.sessionFactory.getCurrentSession().createQuery(hql).uniqueResult()).intValue();
	}
	
	
	public List<Campus> getAllCampuses() {
		
		CriteriaQuery<Campus> cq = entityManager.getCriteriaBuilder().createQuery(Campus.class);
        cq.select(cq.from(Campus.class));
        return entityManager.createQuery(cq).getResultList();
	//	System.out.println("sessionFactory===>"+sessionFactory);
		//String hql = "FROM Campus c ORDER BY c.code";
		// query = this.sessionFactory.getCurrentSession().createQuery(hql);
		// query.list();
	}
	
	
	public List<Campus> getCampusesByStatus(boolean enabled) {
		System.out.println("sessionFactory=================>"+sessionFactory);
		// TODO add unit test for getAllCampusesByStatus()
		String hql = "FROM Campus c WHERE c.enabled = :enabledCode ORDER BY c.code";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		byte enabledCode = enabled? (byte) 1 : (byte) 0;
		query.setParameter("enabledCode", enabledCode);
		return query.list();
	}
}
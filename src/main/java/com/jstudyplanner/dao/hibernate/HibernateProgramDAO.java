package com.jstudyplanner.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jstudyplanner.dao.ProgramDAO;
import com.jstudyplanner.domain.Major;
import com.jstudyplanner.domain.Program;

/**
 * Data Access Object that implements ProgramDAO interface using Hibernate 
 * to persist/update/delete/get Program objects into the database.
 * 
 * All methods apart from setSessionFactory should be executed within
 * transaction. get* methods correspond to readOnly transactions.
 * @author oleg
 */
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class HibernateProgramDAO implements ProgramDAO {

	// injection should be defined in the hibernate-context.xml
	private SessionFactory sessionFactory;
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Transactional(readOnly=false)
	public void add(Program program) {
		if (program.getEnabled() == null) {
			program.setEnabled((byte) 0);
		}
		this.sessionFactory.getCurrentSession().persist(program);
	}

	
	@Transactional(readOnly=false)
	public void save(Program program) {
		if (program.getEnabled() == null) {
			program.setEnabled((byte) 0);
		}
		this.sessionFactory.getCurrentSession().update(program);
	}

	
	@Transactional(readOnly=false)
	public void delete(Program program) {
		this.sessionFactory.getCurrentSession().delete(program);
	}

	
	/**
	 * Attempts to delete program found by given id
	 */
	@Transactional(readOnly=false)
	public void delete(Long id) {
		Program program = (Program) this.sessionFactory.getCurrentSession().get(Program.class, id);
		if (program != null) {
			this.sessionFactory.getCurrentSession().delete(program);
		}
	}

	
	public Program getProgramById(Long id) {
		return (Program) this.sessionFactory.getCurrentSession().get(Program.class, id);
	}

	
	public Program getProgramByCode(String code) {
		String hql = "FROM Program p WHERE p.code = :code";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("code", code);
		List<Program> results = query.list();
		if (results.size() != 0) {
			return results.get(0);
		} else {
			return null;
		}
	}
	
	
	public Program getProgramByTitle(String title) {
		// TODO write test for getProgramByTitle(String title)
		String hql = "FROM Program p WHERE p.title = :title";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("title", title);
		List<Program> results = query.list();
		if (results.size() != 0) {
			return results.get(0);
		} else {
			return null;
		}
	}

	
	public int countAll() {
		String hql = "SELECT COUNT(*) FROM Program";
		return ((Long)this.sessionFactory.getCurrentSession().createQuery(hql).uniqueResult()).intValue();
	}
	
	
	public List<Program> getAllPrograms() {
		String hql = "FROM Program p ORDER BY p.code";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	
	public List<Program> getProgramsByCareer(String career) {
		String hql = "FROM Program p WHERE p.career = :career ORDER BY p.code";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("career", career);
		return query.list();
	}

	
	/**
	 * Get list of courses by status: enabled (true) or disabled (false)
	 */
	public List<Program> getProgramsByStatus(boolean enabled) {
		// TODO add unit test for getAllProgramsByStatus()
		String hql = "FROM Program p WHERE p.enabled = :enabledCode ORDER BY p.code";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		byte enabledCode = enabled? (byte) 1 : (byte) 0;
		query.setParameter("enabledCode", enabledCode);
		return query.list();
	}

	
	public List<Major> getProgramMajors(Program program) {
		String hql = "FROM Major m WHERE m.program = :program ORDER BY m.code";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("program", program);
		return query.list();
	}
}
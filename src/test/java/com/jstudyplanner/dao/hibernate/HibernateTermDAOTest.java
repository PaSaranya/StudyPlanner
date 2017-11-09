package com.jstudyplanner.dao.hibernate;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jstudyplanner.dao.TermDAO;
import com.jstudyplanner.domain.Term;

public class HibernateTermDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(HibernateCampusDAOTest.class);
	private static TermDAO termDAO;
	private static ApplicationContext beansCtx;
	
	@BeforeClass
	public static void setUp() {
		beansCtx = new ClassPathXmlApplicationContext("test-context.xml");
		termDAO = (TermDAO) beansCtx.getBean("termDAO");
	}
	
	/**
	 * This method tests all CRUD operations
	 * DAO should not add object with defined id because id should be assigned
	 * by the database (auto-increment).
	 * This test persists major object into the database, retrieves it back, compares,
	 * deletes it from the database and checks the result. Also checks relationships with
	 * course: compulsoryCourses.
	 * Methods tested:
	 * add(Major)
	 * save(Major)
	 * delete(Major)
	 * delete(Long)
	 * getTermById(Long)
	 * getTermByYearAndNumber(int, int)
	 */
	@Test
	public void testCRUDMajor() {
		Term term1_2012 = (Term) beansCtx.getBean("term1_2012");
		try {
			termDAO.add(term1_2012);
			fail();
		} catch (RuntimeException ex) {
			logger.info("termDAO should not persist term with defined id");
		}
		
		// Test create (add) and read (get*)
		term1_2012.setId(null);
		termDAO.add(term1_2012);
		assertTrue(termDAO.countAll() == 1);
		Term term1_2012FromDB = termDAO.getTermByYearAndNumber(term1_2012.getYear(), term1_2012.getNumber());
		assertNotNull(term1_2012FromDB);
		assertTrue(term1_2012FromDB.compare(term1_2012) == 0);
		
		term1_2012FromDB = termDAO.getTermById(term1_2012FromDB.getId());
		assertNotNull(term1_2012FromDB);
		
		// Test update (save)
		term1_2012.setNumber(2);
		term1_2012.setYear(2013);
		termDAO.save(term1_2012);
		term1_2012FromDB = termDAO.getTermById(term1_2012FromDB.getId());
		assertTrue(term1_2012FromDB.getNumber() == 2);
		assertTrue(term1_2012FromDB.getYear() == 2013);
		
		// Test delete
		termDAO.delete(term1_2012);
		assertNull(termDAO.getTermByYearAndNumber(2013, 2));
		assertNull(termDAO.getTermById(term1_2012FromDB.getId()));
	}
}
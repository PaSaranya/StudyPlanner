package com.jstudyplanner.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * Test the Term domain class: constructor, getters, setters, equals, toString
 * @author oleg, oleglukin@yahoo.com
 */
public class TermTest {
	
	private static final Logger logger = LoggerFactory.getLogger(TermTest.class);
	
	private static Term term1_2012;
	private static Term term2_2012;
	private static Term term1_2013;
	
	/**
	 * Get terms defined in the test-context.xml 
	 */
	@BeforeClass
	public static void setUp() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-context.xml");
		term1_2012 = (Term) ctx.getBean("term1_2012");
		term2_2012 = (Term) ctx.getBean("term2_2012");
		term1_2013 = (Term) ctx.getBean("term1_2013");
	}
	
	@Test
	public void testSetAndGetTermId() {
		Long id = 2l;
		assertEquals(id, term2_2012.getId());
		id++;
		term2_2012.setId(id);
		assertEquals(id, term2_2012.getId());
		term2_2012.setId(--id);
	}
	
	@Test
	public void testSetAndGetTermYear() {
		Integer year = 2012;
		assertEquals(year, term2_2012.getYear());
		year++;
		term2_2012.setYear(year);
		assertEquals(year, term2_2012.getYear());
		term2_2012.setYear(2012);
	}
	
	@Test
	public void testSetAndGetTermNumer() {
		Integer number = 2;
		assertEquals(number, term2_2012.getNumber());
		number++;
		term2_2012.setNumber(number);
		assertEquals(number, term2_2012.getNumber());
		term2_2012.setNumber(2);
	}
	
	@Test
	public void testSetAndGetTermStartDate() {
		Date startDate = new Date(1341398241);
		assertEquals(startDate, term2_2012.getStartDate());
		startDate.setTime(1343644641);
		term2_2012.setStartDate(startDate);
		assertEquals(startDate, term2_2012.getStartDate());
		startDate.setTime(1343212641);
		term2_2012.setStartDate(startDate);
//		assertEquals(startDate, term2_2012.getStartDate());
	}
	
	@Test
	public void testSetAndGetTermFinishDate() {
		Date finishDate = new Date(1350383841);
		assertEquals(finishDate, term2_2012.getFinishDate());
		finishDate.setTime(1351593441);
		term2_2012.setFinishDate(finishDate);
		assertEquals(finishDate, term2_2012.getFinishDate());
		finishDate.setTime(1350383841);;
		term2_2012.setFinishDate(finishDate);
	}
	
	@Test
	public void testCompareTerms() {
		assertFalse(term2_2012.compare(term1_2012) == 0);
		try {
			term2_2012.compare(null);
			fail();
		} catch(NullPointerException e) {
			logger.info("This should through/catch NullPointerException. So fail() is not reached.");
		}
		assertTrue(term2_2012.compare(new Term(1l, 2012, 2, null, null, (byte) 1)) == 0);
		assertTrue(term1_2013.compare(term1_2012) > 0);
		assertTrue(term2_2012.compare(term1_2013) < 0);
	}
}
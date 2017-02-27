package com.exilant.training.spring;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SpringTrainingAppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public SpringTrainingAppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(SpringTrainingAppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}
}

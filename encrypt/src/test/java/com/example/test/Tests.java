package com.example.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class Tests {

	@Before
	public void before() {
		log.info("before...");
	}

	@After
	public void after() {
		log.info("after");
	}

	@BeforeClass
	public static void beforeClass() {
		log.info("beforeClass");
	}

	@AfterClass
	public static void testAfterClass() {
		log.info("afterClass");
	}

	@Test
	public void test() {
		Assert.assertTrue(true);
	}
	
	@Test(expected = RuntimeException.class)
	public void testEx() {
		log.info("test...");
		throw new RuntimeException();
	}

}

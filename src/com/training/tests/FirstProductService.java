package com.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.training.services.ProductServices;

class FirstProductService {

	private ProductServices pServices = new ProductServices();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	@DisplayName("Add method returns more than zero rows")
	void testAddReturnsOneOrMore() {
		
		boolean actual = pServices.add();
		assertEquals(true,actual);
	}

}

package com.skilldistillery.giftr.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EventTypeTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private EventType type;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("giftrPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		type = em.find(EventType.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		type = null;
	}

	@Test
	@DisplayName("test Event Type entity")
	void test() {
		assertNotNull(type);
		assertEquals("Christmas", type.getName());
	}
	
	@Test
	@DisplayName("test Event connect to Event type entity")
	void test1() {
		assertNotNull(type);
		assertNotNull(type.getEvents());
		assertTrue(type.getEvents().size() > 0);
		assertEquals("Secret Santa", type.getEvents().get(0).getName());
	}
	
}

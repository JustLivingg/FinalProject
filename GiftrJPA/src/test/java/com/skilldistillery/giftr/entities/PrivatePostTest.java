package com.skilldistillery.giftr.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Entity
public class PrivatePostTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private PrivatePost privatePost;

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
		privatePost = em.find(PrivatePost.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		privatePost = null;
	}

	@Test
	void test() {
		assertNotNull(privatePost);
		assertEquals("Private Giftr Description", privatePost.getDescription());

	}
}

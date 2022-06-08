package com.skilldistillery.jpacrudweather.entities.test;
//package com.skilldistillery.weather.entities.test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//class SearchKeyowrdTest {
//	private static EntityManagerFactory emf;
//	private EntityManager em;
//	Summit summit;
//
//	@BeforeAll
//	static void setUpBeforeClass() throws Exception {
//		emf = Persistence.createEntityManagerFactory("JPAOutdoorExperience");
//	}
//
//	@AfterAll
//	static void tearDownAfterClass() throws Exception {
//		emf.close();
//	}
//
//	@BeforeEach
//	void setUp() throws Exception {
//		em = emf.createEntityManager();
//		summit = em.find(Summit.class, 1);
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//		em.close();
//		summit = null;
//		
//	}
//
//	@Test
//	void test_search_database_by_keyword_in_description() {
////		mysql> SELECT * From summit where description like "%mount%";
////		+----+---------------+----------------+---------+-----------+-----------+-----------+-------------------------------------------------------------------------------------------------------------------------+---------------------------------------+------------+---------------+
////		| id | name          | state_province | country | longitude | latitude  | elevation | description                                                                                                             | first_send_name                       | first_send | first_attempt |
////		+----+---------------+----------------+---------+-----------+-----------+-----------+-------------------------------------------------------------------------------------------------------------------------+---------------------------------------+------------+---------------+
////		|  1 | Mount Everest | Tibet          | Nepal   | 27.9881*N | 86.9250*E | 29,032'   | Mount Everest is Earth's highest mountain above sea level, located in the Mahalangur Himal sub-range of the Himalayas.  | Sir Edmund Hillary and Tenzing Norgay |       1953 |          1921 |
////		+----+---------------+----------------+---------+-----------+-----------+-----------+-------------------------------------------------------------------------------------------------------------------------+---------------------------------------+------------+---------------+
////		1 row in set (0.01 sec)
//		
//	
//		assertNotNull(summit);
//		assertEquals("Mount Everest is Earth's highest mountain above sea level, located in the Mahalangur Himal sub-range of the Himalayas. ", summit.getDescription());
//	}
//
//
//}
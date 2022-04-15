package com.skilldistillery.jpacrudweather.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.jpacrudweather.entities.Point;

public class TestClient {

	public static void main(String[] args) {
		EntityManagerFactory emf =
			      Persistence.createEntityManagerFactory("JPACRUDWeather");
		EntityManager em = emf.createEntityManager();
		
		Point point = em.find(Point.class, 1);
		
		System.out.println(point);
		
		em.close();
		emf.close();

	}

}

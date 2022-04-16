package com.skilldistillery.jpacrudweather.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpacrudweather.entities.Point;

@Service
@Transactional
public class PointDAOImpl implements PointDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Point findById(int id) {
		return em.find(Point.class, id);
	}

	@Override
	public List<Point> findAll() {
		String query = "SELECT p FROM Point p";
		List<Point> results = em.createQuery(query, Point.class).getResultList();
		return results;
	}
	
	
}

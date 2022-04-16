package com.skilldistillery.jpacrudweather.data;

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
}

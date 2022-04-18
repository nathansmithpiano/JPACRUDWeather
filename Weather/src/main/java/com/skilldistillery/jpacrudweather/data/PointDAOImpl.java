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
	public List<Point> findByCategoryIds(int[] idArray) {
		String query = "SELECT p FROM Point p WHERE category_id = ";
		for (int i = 0; i < idArray.length; i++) {
			if (i == 0) {
				query += idArray[i];
			} else if (idArray.length > 1) {
				query += " OR category_id = " + idArray[i];
			}
		}
		List<Point> results = em.createQuery(query, Point.class).getResultList();
		return results;
	}
	
	@Override
	public List<Point> findUserCreated() {
		String query = "SELECT p FROM Point p WHERE id > 827";
		List<Point> results = em.createQuery(query, Point.class).getResultList();
		return results;
	}

	@Override
	public List<Point> findAll() {
		String query = "SELECT p FROM Point p";
		List<Point> results = em.createQuery(query, Point.class).getResultList();
		return results;
	}

	@Override
	public int addPoint(Point point) {
		em.persist(point);
		em.flush();
		return point.getId();
	}

	@Override
	public Point updatePoint(int id, Point point) {
		Point mPoint = em.find(Point.class, id);
		copyPoint(point, mPoint);
		em.flush();
		return mPoint;
	}

	@Override
	public Point removePoint(Point point) {
		Point backup = new Point();
		copyPoint(point, backup);
		em.remove(point);
		em.flush();
		return backup;
	}
	
	@Override
	public void copyPoint(Point original, Point copy) {
		copy.setName(original.getName());
		copy.setCategoryId(original.getCategoryId());
		copy.setLatitude(original.getLatitude());
		copy.setLongitude(original.getLongitude());
		copy.setElevation(original.getElevation());
		copy.setRangeId(original.getRangeId());
		copy.setIdUrl(original.getIdUrl());
		copy.setCwa(original.getCwa());
		copy.setGridId(original.getGridId());
		copy.setGridX(original.getGridX());
		copy.setGridY(original.getGridY());
		copy.setForecastUrl(original.getForecastUrl());
		copy.setForecastHourly(original.getForecastHourly());
		copy.setrLatitude(original.getrLatitude());
		copy.setrLongitude(original.getrLongitude());
		copy.setrCity(original.getrCity());
		copy.setrState(original.getrState());
		copy.setrCity(original.getrCity());
		copy.setrDistance(original.getrDistance());
		copy.setrBearing(original.getrBearing());
	}

}

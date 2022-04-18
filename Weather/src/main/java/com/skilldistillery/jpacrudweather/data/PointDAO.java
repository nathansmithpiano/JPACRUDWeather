package com.skilldistillery.jpacrudweather.data;

import java.util.List;

import com.skilldistillery.jpacrudweather.entities.Point;

public interface PointDAO {
	
	public Point findById(int id);
	public List<Point> findByCategoryIds(int[] idArray);
	public List<Point> findUserCreated();
	public List<Point> findAll();
	public int addPoint(Point point);
	public Point updatePoint(int id, Point point);
	public Point removePoint(Point point);
	public void copyPoint(Point original, Point copy);

}

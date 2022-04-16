package com.skilldistillery.jpacrudweather.data;

import java.util.List;

import com.skilldistillery.jpacrudweather.entities.Point;

public interface PointDAO {
	
	public Point findById(int id);
	public List<Point> findAll();

}

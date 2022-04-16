package com.skilldistillery.jpacrudweather.data;

import com.skilldistillery.jpacrudweather.entities.Point;

public interface PointDAO {
	
	public Point findById(int id);

}
